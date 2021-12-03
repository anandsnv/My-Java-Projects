using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NumberValidity
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("enter the number between 1 and 10");
            var input = Console.ReadLine();
            var number = Convert.ToInt32(input);
            if (number>1 && number < 10)
            {
                Console.WriteLine("Valid");
            }
            else
            {
                Console.WriteLine("invalid");
            }
        }
    }
}
