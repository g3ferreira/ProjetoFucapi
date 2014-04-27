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
        }



        private void Button_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/PedidoPivot.xaml", UriKind.RelativeOrAbsolute));
       
        }

        private void btnLogar_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menu.xaml", UriKind.RelativeOrAbsolute));
       
        }

    }
}