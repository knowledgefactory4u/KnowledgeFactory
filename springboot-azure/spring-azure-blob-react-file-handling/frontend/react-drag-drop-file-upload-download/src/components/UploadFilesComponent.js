import React, { Component } from "react";
import Dropzone from "react-dropzone";
import UploadService from "../services/UploadFilesService";

export default class UploadFilesComponent
  extends Component {

  constructor(props) {
    super(props);
    this.upload = this.upload.bind(this);
    this.onDrop = this.onDrop.bind(this);
    this.deleteFile = this.deleteFile.bind(this);

    this.state = {
      selectedFiles: undefined,
      currentFile: undefined,
      progress: 0,
      message: "",
      fileInfos: [],
    };
  }

  deleteFile(name){
    UploadService.deleteFile(name).then( res => {
    this. componentDidMount();
    });
}

  componentDidMount() {
    UploadService.getFiles().then((response) => {
      this.setState({
        fileInfos: response.data,
      });
    });
  }

  upload() {
    let currentFile =
      this.state.selectedFiles[0];

    this.setState({
      progress: 0,
      currentFile: currentFile,
    });

    UploadService.upload(currentFile, (event) => {
      this.setState({
        progress: Math.
          round((100 * event.loaded) / event.total),
      });
    })
      .then((response) => {
        this.setState({
          message: response.data.message,
        });
        return UploadService.getFiles();
      })
      .then((files) => {
        this.setState({
          fileInfos: files.data,
        });
      })
      .catch(() => {
        this.setState({
          progress: 0,
          message: "Could not upload the file!",
          currentFile: undefined,
        });
      });

    this.setState({
      selectedFiles: undefined,
    });
  }

  onDrop(files) {
    if (files.length > 0) {
      this.setState({ selectedFiles: files });
    }
  }

  render() {
    const { selectedFiles, currentFile,
      progress, message, fileInfos } = this.state;

    return (
      <div>
        <Dropzone onDrop={this.onDrop} multiple={false}>
          {({ getRootProps, getInputProps }) => (
            <section>
              <div {...getRootProps({ className: "dropzone" })}>
                <input {...getInputProps()} />
                {selectedFiles && selectedFiles[0].name ? (
                  <div className="selected-file">
                    {selectedFiles && selectedFiles[0].name}
                  </div>
                ) : (
                  <h4>Drag and drop file here, or click to 
                           select file</h4>
                )}
              </div>
              <aside className="selected-file-wrapper">
                <button
                  className="btn btn-secondary btn-lg btn-block"
                  disabled={!selectedFiles}
                  onClick={this.upload}>
                  Upload
                </button>
              </aside>
            </section>
          )}
        </Dropzone>
        <br></br>
        {currentFile && (
          <div className="progress mb-3">
            <div className
              ="progress-bar progress-bar-info progress-bar-striped"
              role="progressbar"
              aria-valuenow={progress}
              aria-valuemin="0"
              aria-valuemax="100"
              style={{ width: progress + "%" }}
            >
              {progress}%
            </div>
          </div>
        )}
        <div className="alert alert-light" role="alert">
          {message}
        </div>

        {fileInfos.length > 0 && (
          <div className="card">
              
              <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">File Name</th>
                        <th scope="col">Action</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>    
              {fileInfos.map((file) => (
                <>
                    <tbody>
                      <tr>
                        <td>{file}</td>
        <td><a href={`http://localhost:8080/download/${file}`}
                 class="btn btn-success">Download</a></td>
        <td><button onClick={ () => this.deleteFile(file)}  
                 type="button" class="btn btn-danger">
                       Delete</button></td>
                      </tr>
                    </tbody>
                  </>
              ))}
           </table>
          </div>
        )}
      </div>
    );
  }
}