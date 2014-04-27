using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace SqLiteTeste
{
    public partial class Menu : PhoneApplicationPage
    {
        public Menu()
        {
            InitializeComponent();
        }

        private void btnPedido_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/PedidoPivot.xaml", UriKind.RelativeOrAbsolute));
       
        }

        private void btnUsuario_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/CadUsuario.xaml", UriKind.RelativeOrAbsolute));
      
        }
    }
}