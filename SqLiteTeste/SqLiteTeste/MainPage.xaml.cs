using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using SqLiteTeste.Resources;
using System.IO;
using Windows.Storage;
using SQLite;
using System.Windows.Input;
using System.IO.IsolatedStorage;

namespace SqLiteTeste
{
    public partial class MainPage : PhoneApplicationPage
    {
        public static string db_path = Path.Combine(Path.Combine(ApplicationData.Current.LocalFolder.Path, "dbDandao.sqlite"));


        // Constructor
        public MainPage()
        {
            InitializeComponent();
        
            // Sample code to localize the ApplicationBar
            //BuildLocalizedApplicationBar();
            CopyDatabase();
        }



        private void CopyDatabase()
        {

            IsolatedStorageFile ISF = IsolatedStorageFile.GetUserStoreForApplication();
            String DBFile = "dbDandao.sqlite";
            if (!ISF.FileExists(DBFile)) CopyFromContentToStorage(ISF, "/"+DBFile, DBFile);

        }

        private void CopyFromContentToStorage(IsolatedStorageFile ISF, String SourceFile, String DestinationFile)
        {
            Stream Stream = Application.GetResourceStream(new Uri(SourceFile, UriKind.Relative)).Stream;
            IsolatedStorageFileStream ISFS = new IsolatedStorageFileStream(DestinationFile, System.IO.FileMode.Create, System.IO.FileAccess.Write, ISF);
            CopyStream(Stream, ISFS);
            ISFS.Flush();
            ISFS.Close();
            Stream.Close();
            ISFS.Dispose();
        }

        private void CopyStream(Stream Input, IsolatedStorageFileStream Output)
        {
            Byte[] Buffer = new Byte[5120];
            Int32 ReadCount = Input.Read(Buffer, 0, Buffer.Length);
            while (ReadCount > 0)
            {
                Output.Write(Buffer, 0, ReadCount);
                ReadCount = Input.Read(Buffer, 0, Buffer.Length);
            }
        }



        private SQLiteConnection dbConn;
      
        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            if (dbConn != null)
            {
                /// Close the database connection.
                dbConn.Close();
            }
        }

/*
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            /// Create the database connection.
            dbConn = new SQLiteConnection(db_path);
            /// Create the table Task, if it doesn't exist.
            dbConn.CreateTable<Pessoa>();
           dbConn.CreateTable<Pedido>();
            /// Retrieve the task list from the database.
            List<Pessoa> retrievedTasks = dbConn.Table<Pessoa>().ToList<Pessoa>();
            /// Clear the list box that will show all the tasks.
          PessoaListBox.Items.Clear();
            foreach (var t in retrievedTasks)
           {
              PessoaListBox.Items.Add(t);
          }


             List<Pedido> retrievedPedido = dbConn.Table<Pedido>().ToList<Pedido>();
            /// Clear the list box that will show all the tasks.
            PedidoListBox.Items.Clear();
            foreach (var t in retrievedPedido)
            {
                PedidoListBox.Items.Add(t);
            }
           










        }

        */
        private void txtIdade_KeyUp(object sender, System.Windows.Input.KeyEventArgs e)
        {
            if (e.Key == Key.Enter) insertPessoa();
        }


        public void insertPessoa() { 
                // Create a new task.
            Pessoa pessoa = new Pessoa()
             {
                Nome = txtNome.Text,
                Idade = txtIdade.Text,
                Data = DateTime.Now
             };
            /// Insert the new task in the Task table.
            dbConn.Insert(pessoa);
            /// Retrieve the task list from the database.
            List<Pessoa> retrievedTasks = dbConn.Table<Pessoa>().ToList<Pessoa>();
            /// Clear the list box that will show all the tasks.
            PessoaListBox.Items.Clear();
            foreach (var t in retrievedTasks)
            {
                PessoaListBox.Items.Add(t);
            }
        }



        public void deleteItems()
        {
            SQLiteCommand sqlComm = new SQLiteCommand(dbConn);
            sqlComm.CommandText = "delete from pessoa";
            List<Pessoa> retrievedTasks = sqlComm.ExecuteQuery<Pessoa>();

            if (retrievedTasks.Count == 0)   PessoaListBox.Items.Clear();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
         //   deleteItems();
            //insertPessoa();
        }

        private void btnPedido_Click(object sender, RoutedEventArgs e)
        {

            NavigationService.Navigate(new Uri("/PedidoPivot.xaml", UriKind.RelativeOrAbsolute));
       
            //insertPedido();

          //  NavigationService.Navigate(new Uri("/Pedido.xaml", UriKind.RelativeOrAbsolute));
        }

    }
}