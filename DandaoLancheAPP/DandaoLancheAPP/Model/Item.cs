using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DandaoLancheAPP.Model
{
    public sealed class Item
    {
        [PrimaryKey, AutoIncrement]
        public int iditem { get; set; }
        public int idpedidoitem { get; set; }

        public string nomeproduto { get; set; }

        public string observacao { get; set; }

        public double preco { get; set; }

        public int quantidade { get; set; }

        public double total { get; set; }


        public override string ToString()
        {
            return idpedidoitem + ":" + nomeproduto + ":" + observacao + ":" + quantidade + ":" + preco + total + ":";
        }
    }
}
