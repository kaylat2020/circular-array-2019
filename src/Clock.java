import java.util.Scanner;

/**
 * 
 * @author tuckerka20
 * @version 2/1/19
 */
public class Clock
{
    private static int[] clock;
    private static int currentHr;
    
    public Clock( int hour )
    {
        if ( hour > 12 || hour <= 0 )
        {
            hour = 12;
            System.out.println( "Invalid hour! Setting current time to 12 o'clock." );
        }
        clock = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        currentHr = hour - 1;
    }
    
    public static void main( String args[] )
    {
        Scanner scan = null;
        
        try
        {
            scan = new Scanner( System.in );
            ask( scan );
        }
        catch ( Exception e )
        {
            System.out.print( e );
        }
        finally
        {
            if ( scan != null )
            {
                scan.close();
            }
        }
    }
    
    public static void ask( Scanner scan )
    {
        
        System.out.println( "What time is it?" );
        int hr = scan.nextInt();
        scan.nextLine();
        System.out.println();
        
        Clock time = new Clock( hr );
        
        while ( true )
        {
            System.out.println( time.toString() );
            System.out.println( "Change time by..." );
            int change = scan.nextInt();
            increaseHour( change );
            scan.nextLine();
            System.out.println();
        }
    }
    
    public static int getHour()
    {
        return clock[ currentHr ];
    }
    
    public static void increaseHour( int numHrs )
    {
        int counter = clock[0] - 1;
        
        if ( numHrs >= clock[0] - 1 )
        {
            int i = currentHr;
            while ( counter < numHrs )
            {
                i++;
                if ( i > clock[clock.length - 1] - 1 )
                {
                    i = clock[0] - 1;
                }
                counter++;
            }
            currentHr = i;
        }
        else
        {
            int i = currentHr;
            while ( counter > numHrs )
            {
                i--;
                if ( i < clock[0] - 1 )
                {
                    i = clock[clock.length - 1] - 1;
                }
                counter--;
            }
            currentHr = i;
        }
    }
    
    public String toString()
    {
        return "It is now " + getHour() + " o'clock.";
    }
}
