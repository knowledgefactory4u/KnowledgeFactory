yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; ' +
                'charset=utf-8"')
        title("Groovy example")
        link(rel: "stylesheet", type: "text/css",
        href: "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css")
    }
    body {
        div(class: 'container') {
            if (create) {
                h1("Create a User:")
            } else {
                h1("Edit User")
            }
            a(class: 'btn btn-primary', href: "/", "Back to User List")
            br()
            br()
            form(id: "editForm", action: "$actionUrl", method: "POST") {
                table(class: 'table') {
                    if (!create) {
                        tr {
                            td("Id")
                            td(":")
                            td(user.id ?: '')
                        }
                    }
                    tr {
                        td("First Name")
                        td(":")
                        td {
                            input(name: 'first_name', type: 'text',
                                    value: user.last_name ?: '')
                        }
                    }
                    tr {
                        td("Last Name")
                        td(":")
                        td {
                            input(name: 'last_name', type: 'text',
                                    value: user.last_name ?: '')
                        }
                    }
                    tr {
                        td("Email")
                        td(":")
                        td {
                            input(name: 'email', type: 'text',
                                    value: user.email ?: '')
                        }
                    }
                }
                br()
                if (create) {
                    input(class: 'btn btn-success', type: 'submit',
                            value: 'Create')
                } else {
                    input(class: 'btn btn-success', type: 'submit',
                            value: 'Update')
                }
            }
        }
    }
}