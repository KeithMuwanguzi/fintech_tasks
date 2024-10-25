#Muwanguzi Keith Jonathan
#Python Object Oriented Programming

from abc import ABC, abstractmethod
import math

class Shape(ABC):

    #Abstract methods that must be implemented in all inheriting classes
    @abstractmethod
    def calculate_area(self):
        pass

    @abstractmethod
    def calculate_perimeter(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.__radius = radius   #This is a private variable

    def calculate_area(self):
        return math.pi * self.__radius ** 2

    def calculate_perimeter(self):
        return 2 * math.pi * self.__radius

class Rectangle(Shape):
    def __init__(self, length, width):
        self.__length = length   #This is a private variable
        self.__width = width   #This is a private variable

    def calculate_area(self):
        return self.__length * self.__width

    def calculate_perimeter(self):
        return 2 * (self.__length + self.__width)

# Demonstrating polymorphism-- ALl the methods will access this method
def print_shape_info(shape):
    print(f"Area: {shape.calculate_area()}")
    print(f"Perimeter: {shape.calculate_perimeter()}")

# Creating instances
circle = Circle(5)
rectangle = Rectangle(4, 6)
# You can not directly instantiate Shape because it is an abstract class

# Using polymorphism
print("Circle:")
print_shape_info(circle)

print("\nRectangle:")
print_shape_info(rectangle)

