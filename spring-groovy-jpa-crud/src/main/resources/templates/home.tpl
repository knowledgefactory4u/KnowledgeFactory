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
            h2("User CRUD operation with Groovy Template")
            div {
                nobr {
                    a(class: 'btn btn-primary', href: "/create", "Add User")
                }
            }
            br()
            br()
            div {
                table(class: 'table') {
                    tr {
                        th("Id")
                        th("First Name")
                        th("Last Name")
                        th("Email")
                        th("")
                        th("")
                    }
                    users.each { user ->
                        tr {
                            td("$user.id")
                            td("$user.first_name")
                            td("$user.last_name")
                            td("$user.email")
                            td {
                                a(class: 'btn btn-warning',
                                        href: "/update/$user.id", "Edit")
                            }
                            td {
                                a(class: 'btn btn-danger',
                                        href: "/delete/$user.id", "Delete")
                            }
                        }
                    }
                }
            }

        }
    }
}
