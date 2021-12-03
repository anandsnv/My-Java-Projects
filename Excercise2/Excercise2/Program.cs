using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Excercise2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the First number");
            var input = Console.ReadLine();
            var number1 = Convert.ToInt32(input);
            Console.WriteLine("Enter the Second Number");
            var input1 = Console.ReadLine();
            var number2 = Convert.ToInt32(input);
            if (number1 > number2) { 
            Console.WriteLine("Max is " + number1);
             }
            else
            {
                Console.WriteLine("Max is" + number2);
            }
        }
    }
}
