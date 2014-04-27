using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SqLiteTeste
{
    public sealed class Usuario
    {
        [PrimaryKey, AutoIncrement]
        public int idusuario { get; set; }
        public string login { get; set; }

        public string senha { get; set; }

        public string nome { get; set; }

        public string telefone { get; set; }
   
        public string endereco { get; set; }
   
    
    }
}
