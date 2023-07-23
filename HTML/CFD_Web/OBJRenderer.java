package CFD_Web;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.io.*;
import java.nio.*;
import java.util.*;

public class OBJRenderer {
    private long window;
    private List<Float> vertices = new ArrayList<>();

    public void run() {
        init();
        loop();
        cleanup();
    }

    private void init() {
        // Initialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW (optional)
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        // Create the window
        window = glfwCreateWindow(800, 600, "OBJ Renderer", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Load the .obj file
        try {
            loadOBJ("path/to/your/obj/file.obj");
        } catch (IOException e) {
            System.err.println("Error loading .obj file: " + e.getMessage());
            System.exit(-1);
        }

        // Set up OpenGL settings (optional)
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    private void loadOBJ(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("v ")) {
                String[] vertexComponents = line.split("\\s+");
                float x = Float.parseFloat(vertexComponents[1]);
                float y = Float.parseFloat(vertexComponents[2]);
                float z = Float.parseFloat(vertexComponents[3]);
                vertices.add(x);
                vertices.add(y);
                vertices.add(z);
            }
        }

        reader.close();
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // Render the 3D object here using the loaded vertices
            renderObject();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    private void renderObject() {
        glBegin(GL_TRIANGLES);

        // Render the object using the loaded vertices
        for (int i = 0; i < vertices.size(); i += 3) {
            float x = vertices.get(i);
            float y = vertices.get(i + 1);
            float z = vertices.get(i + 2);
            glVertex3f(x, y, z);
        }

        glEnd();
    }

    private void cleanup() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public static void main(String[] args) {
        OBJRenderer renderer = new OBJRenderer();
        renderer.run();
    }
}
