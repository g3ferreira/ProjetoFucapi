using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using SQLite;
using System.IO;
using Windows.Storage;
using System.Windows.Input;

namespace SqLiteTeste
{
    public partial class PedidoPage : PhoneApplicationPage
    {

        public PedidoPage()
        {
            InitializeComponent();
            this.lstpProdutos.ItemsSource = Produtos;
         //   gerarListQuantidade();
         
        }

        String[] Produtos = { "X-SALADA","X-BACON",
                              "X-BURGER","X-TUDO",
                              "SOPA","COCA-COLA",
                              "FANTA","MOUSSE","SUCO/LARANJA"};

        String[] Precos = { "4.5","5.5",
                              "3","6",
                              "7.5","3.5",
                              "3.5","2.5","3.5"};




        List<String> listQtd = new List<String>();

        public static string db_path = Path.Combine(Path.Combine(ApplicationData.Current.LocalFolder.Path, "dbDandao.sqlite"));

        private SQLiteConnection dbConn;

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            if (dbConn != null)
            {
                /// Close the database connection.
                dbConn.Close();
            }
        }


        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            /// Create the database connection.
            dbConn = new SQLiteConnection(db_path);
            /// Create the table Task, if it doesn't exist.
            dbConn.CreateTable<Item>();
            dbConn.CreateTable<Pedido>();
            
            //List<Pedido> retrievedPedido = dbConn.Table<Pedido>().ToList<Pedido>();
            /// Clear the list box that will show all the tasks.
        /*    PedidoListBox.Items.Clear();
            foreach (var t in retrievedPedido)
            {
                PedidoListBox.Items.Add(t);
            }
            */

        }

        public void insertPedido()
        {
            // Create a new task.
            Pedido pedido = new Pedido()
            {
                status = "NP"
                
            };
            /// Insert the new task in the Task table.
            dbConn.Insert(pedido);
            /// Retrieve the task list from the database.
     //       List<Pedido> retrievedTaskPedido = dbConn.Table<Pedido>().ToList<Pedido>();
            /// Clear the list box that will show all the tasks.
        }


        public void insertItem()
        {
            // Create a new task.
            Item item = new Item()
            {
                idpedidoitem = selectionIDPedido(),        
                nomeproduto = lstpProdutos.SelectedItem.ToString(),
                quantidade = Convert.ToInt32(txtQtd.Text),
                observacao = txtObservacao.Text,
                total = Convert.ToInt32(txtQtd.Text) * Convert.ToInt32(Precos[lstpProdutos.SelectedIndex])

            };
            /// Insert the new task in the Task table.
            dbConn.Insert(item);
            /// Retrieve the task list from the database.
            //       List<Pedido> retrievedTaskPedido = dbConn.Table<Pedido>().ToList<Pedido>();
            /// Clear the list box that will show all the tasks.
        }


        private void txtIdade_KeyUp(object sender, System.Windows.Input.KeyEventArgs e)
        {
            //if (e.Key == Key.Enter) insertPessoa();
        }


        

        public void deleteItems()
        {
            SQLiteCommand sqlComm = new SQLiteCommand(dbConn);
            sqlComm.CommandText = "delete from pessoa";
            List<Pessoa> retrievedTasks = sqlComm.ExecuteQuery<Pessoa>();

        //    if (retrievedTasks.Count == 0) PessoaListBox.Items.Clear();
        }


        public int selectionIDPedido()
        {
            SQLiteCommand sqlComm = new SQLiteCommand(dbConn);
            sqlComm.CommandText = "select max(idpedido) from pedido";
            List<Pedido> pedido = sqlComm.ExecuteQuery<Pedido>();
            return pedido[0].idpedido;
            //    if (retrievedTasks.Count == 0) PessoaListBox.Items.Clear();
        }

         
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            //   deleteItems();
            //insertPessoa();
        }

        private void btnPedido_Click(object sender, RoutedEventArgs e)
        {

            NavigationService.Navigate(new Uri("/PedidoPage.xaml", UriKind.RelativeOrAbsolute));

            //insertPedido();

            //  NavigationService.Navigate(new Uri("/Pedido.xaml", UriKind.RelativeOrAbsolute));
        }

        private void btnInsertItem_Click(object sender, RoutedEventArgs e)
        {
            insertItem();
        }


    }
}