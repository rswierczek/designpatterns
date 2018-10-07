package learning.rasw.designpatterns.bridge.example1;


interface Renderer
{
    String whatToRenderAs();
}

abstract class Shape
{

    protected Renderer renderer;
    public Shape(Renderer renderer){
        this.renderer = renderer;
    }

    public abstract String getName();

    public String toString()
    {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class Triangle extends Shape
{
    public Triangle(Renderer renderer){
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }
}

class Square extends Shape
{

    public Square(Renderer renderer){
        super(renderer);
    }
    @Override
    public String getName()
    {
        return "Square";
    }
}

class VectorRenderer implements Renderer
{
    @Override
    public String whatToRenderAs()
    {
        return "lines";
    }
}

class RasterRenderer implements Renderer
{
    @Override
    public String whatToRenderAs()
    {
        return "pixels";
    }
}
public class Demo {
    public static void main(String[] args) {

        System.out.println(new Triangle(new RasterRenderer()).toString());
        System.out.println(new Triangle(new VectorRenderer()).toString());

        System.out.println(new Square(new RasterRenderer()).toString());
        System.out.println(new Square(new VectorRenderer()).toString());
    }
}
