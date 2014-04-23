using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.IO;
using Windows.Storage;
using SQLite;
using DandaoLancheAPP.Model;

namespace DandaoLancheAPP.View
{
    public partial class PivotPedido : PhoneApplicationPage
    {
        double totalPedido;
        bool pedidoFinalizado = false;
        public PivotPedido()
        {
        
            InitializeComponent();
            this.lstpProdutos.ItemsSource = Produtos;

         
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

            List<Item> retrievedPedido = dbConn.Table<Item>().ToList<Item>();
            /// Clear the list box that will show all the tasks.
            ListPedido.Items.Clear();

                foreach (var t in retrievedPedido)
                {
                    ListPedido.Items.Add(t);
                }


                if (pedidoFinalizado != true)
                {
                    insertPedido();
                    txtbIDPedido.Text = selectionIDPedido().ToString();
              
              
                }
                else
                {
                    pedidoFinalizado = false;
                }

            
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
                preco = Convert.ToDouble(Precos[lstpProdutos.SelectedIndex]),
                total = Convert.ToDouble(txtQtd.Text) * Convert.ToDouble(Precos[lstpProdutos.SelectedIndex])
               
            };
            /// Insert the new task in the Task table.
            dbConn.Insert(item);
            /// Retrieve the task list from the database.
            List<Item> retrievedTaskPedido = dbConn.Table<Item>().ToList<Item>();
            /// Clear the list box that will show all the tasks.
            foreach (var t in retrievedTaskPedido)
            {
                ListPedido.Items.Add(t);
            }
            ListPedido.Visibility = Visibility.Visible;
            totalPedido = totalPedido + (Convert.ToDouble(txtQtd.Text) * Convert.ToDouble(Precos[lstpProdutos.SelectedIndex]));
            txtbTotalPedido.Text = totalPedido.ToString();
        }


        private void txtIdade_KeyUp(object sender, System.Windows.Input.KeyEventArgs e)
        {
            //if (e.Key == Key.Enter) insertPessoa();
        }




        public void deleteItems()
        {
            SQLiteCommand sqlComm = new SQLiteCommand(dbConn);
            sqlComm.CommandText = "delete from item";
            List<Item> retrievedTasks = sqlComm.ExecuteQuery<Item>();

                if (retrievedTasks.Count == 0) ListPedido.Items.Clear();
        }

        public void deletePedido()
        {
            SQLiteCommand sqlComm = new SQLiteCommand(dbConn);
            sqlComm.CommandText = "delete from pedido";
            List<Item> retrievedTasks = sqlComm.ExecuteQuery<Item>();

            if (retrievedTasks.Count == 0) ListPedido.Items.Clear();
        }


        public int selectionIDPedido()
        {
            SQLiteCommand sqlComm = new SQLiteCommand(dbConn);
            sqlComm.CommandText = "select *  from Pedido order by idpedido desc";
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

        private void ctxtDeletar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void ctxtAlterar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnRemover_Click(object sender, RoutedEventArgs e)
        {

            deleteItems();
            deletePedido();
        }



    }
}