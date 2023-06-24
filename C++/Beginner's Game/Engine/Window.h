#pragma once
#include <GLFW/glfw3.h>

class Window
{
private:
    /* data */
public:
    bool init();
    bool release();

    Window(/* args */);
    ~Window();
};

Window::Window(/* args */)
{
}

Window::~Window()
{
}
