package com.azure.container.services;

import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.resourcemanager.AzureResourceManager;

public class AzureContainerServices {

	public static void main(String[] args) {
		
		AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
		AzureResourceManager azure = AzureResourceManager
				.authenticate(new DefaultAzureCredentialBuilder().build(), profile).withDefaultSubscription();

		AciService aciService = new AciService(azure);

		AzureConfig config = new AzureConfig();
		config.setResourceGroup("myResourceGroup");
		config.setContainerGroupName("myContainerGroup");
		config.setContainerName("myContainer");
		config.setContainerImage("nginx");
		config.setPort(80);
		config.setRegion(com.azure.core.management.Region.US_EAST);

		aciService.deployContainerInstance(config);
	}
}
