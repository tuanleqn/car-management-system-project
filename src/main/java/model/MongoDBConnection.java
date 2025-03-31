package model;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {
	private static MongoDBConnection instance;
	private MongoClient mongoClient;
	private MongoDatabase database;
	private static final String DATABASE_NAME = "CO2039DB";
	private static final String CONNECTION_STRING = "mongodb+srv://tuanleqn04:zcN8yWOMTroraocJ@cluster0.8k9ej.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
	
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://tuanleqn04:zcN8yWOMTroraocJ@cluster0.8k9ej.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("CO2039DB");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Private constructor to prevent instantiation outside this class
    private MongoDBConnection() {
    	ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
    	
    	MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .serverApi(serverApi)
                .build();
        // Create a MongoClient instance using the connection string
        this.mongoClient = MongoClients.create(settings);
        // Get the MongoDatabase instance for the specified database name
        this.database = mongoClient.getDatabase(DATABASE_NAME);
    }
    
    // Method to provide access to the MongoDBConnection instance
    public static synchronized MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }
    
    // Method to get the MongoDatabase instance
    public MongoDatabase getDatabase() {
        return this.database;
    }
    
    // Method to close the MongoClient connection
    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
