package com.knf.dev.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

@Configuration
public class AzureBlobConfig {

	@Value("${azure.storage.connection.string}")
	private String connectionString;

	@Value("${azure.storage.container.name}")
	private String containerName;

	@Bean
	public BlobServiceClient clobServiceClient() {

		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString)
				.buildClient();

		return blobServiceClient;

	}

	@Bean
	public BlobContainerClient blobContainerClient() {

		BlobContainerClient blobContainerClient = clobServiceClient().getBlobContainerClient(containerName);

		return blobContainerClient;

	}

}