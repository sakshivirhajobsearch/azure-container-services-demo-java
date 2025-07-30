package com.azure.container.services;

import java.util.List;

import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.containerservice.models.KubernetesCluster;

public class AksService {
	
	private final AzureResourceManager azure;

	public AksService(AzureResourceManager azure) {
		this.azure = azure;
	}

	public void listAKSClusters() {
		
		System.out.println("Listing AKS clusters:");
		List<KubernetesCluster> clusters = azure.kubernetesClusters().list().stream().toList();
		if (clusters.isEmpty()) {
			System.out.println("No AKS clusters found.");
		} else {
			clusters.forEach(cluster -> {
				System.out.println("Cluster: " + cluster.name() + ", Region: " + cluster.regionName());
			});
		}
	}
}