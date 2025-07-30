package com.azure.container.services;

import java.util.List;

import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.containerinstance.models.ContainerGroup;
import com.azure.resourcemanager.containerinstance.models.ContainerGroupRestartPolicy;

public class AciService {

	private final AzureResourceManager azure;

	public AciService(AzureResourceManager azure) {
		this.azure = azure;
	}

	public void listACIInstances() {
		
		System.out.println("Listing Azure Container Instances:");
		List<ContainerGroup> groups = azure.containerGroups().list().stream().toList();
		if (groups.isEmpty()) {
			System.out.println("No container groups found.");
		} else {
			groups.forEach(group -> System.out.println("ACI: " + group.name() + ", Region: " + group.regionName()));
		}
	}

	public void deployContainerInstance(AzureConfig config) {
		
		System.out.println("Deploying Azure Container Instance...");

		azure.containerGroups().define(config.getContainerGroupName()).withRegion(config.getRegion())
				.withExistingResourceGroup(config.getResourceGroup()).withLinux().withPublicImageRegistryOnly()
				.withoutVolume().defineContainerInstance(config.getContainerName())
				.withImage(config.getContainerImage()).withExternalTcpPort(config.getPort()).withCpuCoreCount(1.0)
				.withMemorySizeInGB(1.5).attach().withRestartPolicy(ContainerGroupRestartPolicy.ALWAYS).create();

		System.out.println("Container instance deployed successfully.");
	}
}
