﻿#pragma checksum "C:\Users\Genilson Ferreira\Desktop\SqLiteTeste\SqLiteTeste\Pedido.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "203B4A82D133619841E13A5196AB8CEA"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.34014
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Phone.Controls;
using System;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interop;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using System.Windows.Threading;


namespace SqLiteTeste {
    
    
    public partial class Pedido : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal System.Windows.Controls.Grid ContentPanel;
        
        internal System.Windows.Controls.ListBox PedidoListBox;
        
        internal System.Windows.Controls.TextBox txtNomeProduto;
        
        internal System.Windows.Controls.TextBlock txtbNome;
        
        internal System.Windows.Controls.TextBox txtQuantidade;
        
        internal System.Windows.Controls.TextBlock txtbIdade;
        
        internal System.Windows.Controls.TextBox txtPreco;
        
        internal System.Windows.Controls.TextBlock txtbPreco;
        
        internal System.Windows.Controls.Button btnCriarTable;
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Windows.Application.LoadComponent(this, new System.Uri("/SqLiteTeste;component/Pedido.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.ContentPanel = ((System.Windows.Controls.Grid)(this.FindName("ContentPanel")));
            this.PedidoListBox = ((System.Windows.Controls.ListBox)(this.FindName("PedidoListBox")));
            this.txtNomeProduto = ((System.Windows.Controls.TextBox)(this.FindName("txtNomeProduto")));
            this.txtbNome = ((System.Windows.Controls.TextBlock)(this.FindName("txtbNome")));
            this.txtQuantidade = ((System.Windows.Controls.TextBox)(this.FindName("txtQuantidade")));
            this.txtbIdade = ((System.Windows.Controls.TextBlock)(this.FindName("txtbIdade")));
            this.txtPreco = ((System.Windows.Controls.TextBox)(this.FindName("txtPreco")));
            this.txtbPreco = ((System.Windows.Controls.TextBlock)(this.FindName("txtbPreco")));
            this.btnCriarTable = ((System.Windows.Controls.Button)(this.FindName("btnCriarTable")));
        }
    }
}

