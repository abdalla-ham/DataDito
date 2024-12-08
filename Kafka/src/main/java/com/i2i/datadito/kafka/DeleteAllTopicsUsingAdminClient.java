package com.i2i.datadito.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.common.errors.TopicExistsException;
import org.apache.kafka.common.errors.UnknownTopicOrPartitionException;
import org.apache.kafka.clients.admin.AdminClientConfig;
import java.util.concurrent.ExecutionException;

public class DeleteAllTopicsUsingAdminClient {

    public static void main(String[] args) {
        // Configure the AdminClient
        var config = new java.util.Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Adjust if necessary

        try (AdminClient adminClient = AdminClient.create(config)) {
            // List all topics
            ListTopicsResult listTopicsResult = adminClient.listTopics();
            var topics = listTopicsResult.names().get();

            // Delete all topics
            if (!topics.isEmpty()) {
                System.out.println("Deleting topics: " + topics);
                DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(topics);
                deleteTopicsResult.all().get(); // This will block until the delete is done
                System.out.println("All topics deleted successfully.");
            } else {
                System.out.println("No topics found to delete.");
            }

        } catch (UnknownTopicOrPartitionException e) {
            System.err.println("Error: One or more topics could not be found.");
        } catch (TopicExistsException e) {
            System.err.println("Error: Topic already exists.");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("Error while deleting topics: " + e.getMessage());
        }
    }
}
