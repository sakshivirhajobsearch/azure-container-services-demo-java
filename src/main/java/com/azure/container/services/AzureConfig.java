package com.azure.container.services;

import com.azure.core.management.Region;

public class AzureConfig {
	
	private String resourceGroup;
	private String containerGroupName;
	private String containerName;
	private String containerImage;
	private int port;
	private Region region;

	// Getters and setters
	public String getResourceGroup() {
		return resourceGroup;
	}

	public void setResourceGroup(String resourceGroup) {
		this.resourceGroup = resourceGroup;
	}

	public String getContainerGroupName() {
		return containerGroupName;
	}

	public void setContainerGroupName(String containerGroupName) {
		this.containerGroupName = containerGroupName;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public String getContainerImage() {
		return containerImage;
	}

	public void setContainerImage(String containerImage) {
		this.containerImage = containerImage;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
