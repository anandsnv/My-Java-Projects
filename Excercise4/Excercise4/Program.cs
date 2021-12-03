using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Excercise4
{
    internal class Program
    {
        static void Main(string[] args)
        { 

            int output = 1;
            Console.WriteLine("Enter the number to find the Factorial");
            var input=Console.ReadLine();
            var number=Convert.ToInt32(input);
            for(int i = 1; i <=number; i++)
            {
                output = output * i;
            }
            Console.WriteLine(output);
        }
    }
}
