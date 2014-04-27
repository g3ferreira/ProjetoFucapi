using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SqLiteTeste
{
    public sealed class Pessoa
    {
        [PrimaryKey, AutoIncrement]
        public int Id { get; set; }

        public string Nome { get; set; }

        public string Idade { get; set; }

        public DateTime Data { get; set; }

        public override string ToString()
        {
            return Nome + ":" + Idade + " < " + Data.ToShortDateString() + " " + Data.ToShortTimeString();
        }
    }
}
