# Chat-Application
Welcome to the Chat Application project! This desktop-based chat platform is inspired by popular messaging applications like Messenger. It allows users to send and receive messages, images, and videos, while maintaining a clean and intuitive user interface. The application also stores conversations in a SQL Server database, ensuring that past conversations are retrieved whenever the app is opened.


Features
1-Real-time Messaging: Users can send and receive text messages instantly.
2-Multimedia Support: Users can send and receive images and video files.
3-Message Persistence: Conversations are stored in a SQL Server database, allowing users to access past conversations.
4-File Storage: Images and videos are stored for later retrieval.
5-User-friendly GUI: The application offers a sleek and intuitive interface built with Java SE's GUI components.
6-Client-Server Architecture: Ensures scalability and allows for efficient data management.
7-Multi-threading: The server handles multiple client requests concurrently using multi-threading to ensure smooth performance and responsiveness.



Architecture
The application uses a client-server architecture with multi-threading for handling multiple connections at once:

1-The client is built using Java SE with a GUI framework, providing an intuitive desktop interface for users to send and receive messages.
2-The server processes requests, manages message storage, and interacts with the SQL Server database to store and retrieve messages and multimedia files. Using multi-threading, the server can handle multiple clients simultaneously, ensuring seamless communication



Workflow
1-The user sends a message or multimedia file from the client.
2-The client forwards the request to the server.
3-The server stores the message and any associated media in the SQL Server database.
4-The server retrieves and sends past conversation history to the client when the app is reopened.
5-Multi-threading allows the server to manage multiple client connections and requests concurrently, preventing any delay or interruption during messaging.
