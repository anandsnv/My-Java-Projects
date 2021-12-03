using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Excercise3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int count = 0;
            for(int i = 1; i < 100; i++)
            {
                if (i % 3 == 0)
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}
