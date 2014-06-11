import java.util.Scanner;
public class MathApp
{
    public static void main()
    {
        double x = 0;
        double y = 0;
        double z = 0;
        do
        {
            x = getDouble( "Enter value for x: " );
            y = getDouble( "Enter value for y: " );
            z = getDouble( "Enter value for z: " );
            double xValue = checkValidity( x*y, "x" );
            double yValue = checkValidity( x*z, "y" );
            double zValue = checkValidity( x*(y+z)-y, "z" );
            int ySize = checkSize( yValue );
            int zSize = checkSize( zValue );
            double answer = checkValidity(( xValue * Math.pow(10, ySize) * Math.pow(10, zSize) ) + ( yValue * Math.pow(10, zSize) ) + zValue, "answer");
            if( answer - Math.floor( answer ) > 0 )
            {
                System.out.println("Your answer is: " + answer + "\n");
            }
            else
            {
                System.out.println("Your answer is: " + (int)answer + "\n");
            }
        }
        while( x != 0 && y != 0 && z != 0 );
    }
    
    public static double getDouble( String prompt )
    {
        Scanner scanner = new Scanner(System.in);
        String stringValue = "";
        double doubleValue = 0;
        boolean repeat = true;
        do 
        {
            System.out.print( prompt );
            stringValue = scanner.next();
            try
            {
                doubleValue = Double.parseDouble( stringValue );
                repeat = false;
            }
            catch (NumberFormatException nfex)
            {
                prompt = "Please enter a valid number: "; 
            }
        } while (repeat);
        return doubleValue;
    }
    
    public static double checkValidity( double value, String name )
    {
        if( value > Double.MAX_VALUE ) 
        { 
            value = Double.MAX_VALUE;
            System.out.println( "Warning: Max Value Exceeded. Rounded " + name + "." );
        }
        if( value < -Double.MAX_VALUE ) 
        { 
            value = -Double.MAX_VALUE; 
            System.out.println( "Warning: Max Negative Value Exceeded. Rounded " + name + "." );
        }
        return value;
    }
    
    public static int checkSize( double value )
    {
        if( value < 0 ){ value *= -1; }
        else if( value == 0 ){ value = 1; }
        int highestValue = (int)Math.floor( Math.log( value ) );
        int size = 1;
        boolean stop = false;
        if( highestValue >= 1 )
        {
            do
            {
                double checkNumber = Math.pow(10, highestValue);
                while( value >= checkNumber)
                {
                    size += highestValue;
                    value /= checkNumber;
                    stop = true;
                }
            }while( highestValue-- >1 && !stop);
        }
        return size;
    }
}

