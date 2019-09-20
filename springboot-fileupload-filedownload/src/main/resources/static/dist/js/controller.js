$(function() {
	load()
	$('button[type=submit]')
			.click(
					function(e) {
						e.preventDefault();
						// Disable submit button
						$(this).prop('disabled', true);

						var form = document.forms[0];
						var formData = new FormData(form);

						// Ajax call for file uploaling
						var ajaxReq = $
								.ajax({
									url : 'uploadFile',
									type : 'POST',
									data : formData,
									cache : false,
									contentType : false,
									processData : false,
									xhr : function() {
										// Get XmlHttpRequest object
										var xhr = $.ajaxSettings.xhr();

										// Set onprogress event handler
										xhr.upload.onprogress = function(event) {
											var perc = Math
													.round((event.loaded / event.total) * 100);
											$('#progressBar').text(perc + '%');
											$('#progressBar').css('width',
													perc + '%');
										};
										return xhr;
									},
									beforeSend : function(xhr) {
										// Reset alert message and progress bar
										$('#alertMsg').text('');
										$('#progressBar').text('');
										$('#progressBar').css('width', '0%');
									}
								});

						// Called on success of file upload
						ajaxReq
								.done(function(msg) {
									$('#alertMsg').text(
											"File Uploaded successfully");
									$('input[type=file]').val('');
									$('button[type=submit]').prop('disabled',
											false);

									var trHTML = '';
									trHTML += '<h3>Download file</h3><ul class="list-group">'
									for (var i = 0; i < msg.length; i++) {
										var item = msg[i];
										trHTML += '<li class="list-group-item"><a href="download?param='
												+ item
												+ '">'
												+ item
												+ '</a></li>'

									}
									trHTML += '</ul>'
									$('#download').html(trHTML);
								});

						// Called on failure of file upload
						ajaxReq.fail(function(jqXHR) {
							$('#alertMsg').text(
									jqXHR.responseText + '(' + jqXHR.status
											+ ' - ' + jqXHR.statusText + ')');
							$('button[type=submit]').prop('disabled', false);
						});
					});

	function load() {
		$
				.ajax({
					type : "GET",

					url : "getListOfFiles",

					error : function(xhr, status, error) {
						var err = eval("(" + xhr.responseText + ")");
						alert(err.Message);
					},
					success : function(msg) {
						var trHTML = '';
						trHTML += '<h3>Download file</h3><ul class="list-group">'
						for (var i = 0; i < msg.length; i++) {
							var item = msg[i];
							trHTML += '<li class="list-group-item"><a href="download?param='
									+ item + '">' + item + '</a></li>'

						}
						trHTML += '</ul>'
						$('#download').html(trHTML);
					}
				});
	}

});