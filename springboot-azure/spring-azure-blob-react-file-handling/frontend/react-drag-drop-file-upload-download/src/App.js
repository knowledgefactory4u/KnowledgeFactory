import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadFiles from "./components/UploadFilesComponent";

function App() {
  return (

    <div>
      <nav class="navbar navbar-dark bg-dark">
        <div class="btn-group mx-auto">
          <h4 class="text-white">Azure Blob Storage 
          + Spring Boot + React - File Upload
            , Download, & Delete</h4>
        </div>
      </nav><br></br>
      <div class="container">
        <UploadFiles />
      </div></div>
  );
}

export default App;
