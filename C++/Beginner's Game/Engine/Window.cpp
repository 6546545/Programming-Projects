#include "Window.h"

Window::Window(){


}
bool Window::init(){
    if (!glfwInit())
    {
        return -1;
    }
    
    return true;
}
bool Window::release(){
    return true;
}

Window::~Window(){

}