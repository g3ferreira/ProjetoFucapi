using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DandaoLancheAPP.Model
{
    public sealed class Pedido
    {
        [PrimaryKey, AutoIncrement]
        public int idpedido { get; set; }

        public string status { get; set; }

        public DateTime data { get; set; }

        public double total { get; set; }

        public override string ToString()
        {
            return idpedido + ":" + total + " < " + data.ToShortDateString();
        }

    }
}
