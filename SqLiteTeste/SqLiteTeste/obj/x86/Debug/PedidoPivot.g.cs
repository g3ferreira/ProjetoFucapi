﻿#pragma checksum "C:\ProjetoFucapi\SqLiteTeste\SqLiteTeste\PedidoPivot.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "A9D334A6A4F6D239406E3616C637B253"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.34003
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
    
    
    public partial class PedidoPivot : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal System.Windows.Controls.TextBlock txtbIDPedido;
        
        internal Microsoft.Phone.Controls.ListPicker lstpProdutos;
        
        internal System.Windows.Controls.TextBox txtObservacao;
        
        internal System.Windows.Controls.TextBox txtQtd;
        
        internal System.Windows.Controls.TextBlock txtbTotalPedido;
        
        internal System.Windows.Controls.Button btnInsertItem;
        
        internal System.Windows.Controls.Grid gridAqui;
        
        internal System.Windows.Controls.ListBox ListPedido;
        
        internal System.Windows.Controls.Button btnRemover;
        
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
            System.Windows.Application.LoadComponent(this, new System.Uri("/SqLiteTeste;component/PedidoPivot.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.txtbIDPedido = ((System.Windows.Controls.TextBlock)(this.FindName("txtbIDPedido")));
            this.lstpProdutos = ((Microsoft.Phone.Controls.ListPicker)(this.FindName("lstpProdutos")));
            this.txtObservacao = ((System.Windows.Controls.TextBox)(this.FindName("txtObservacao")));
            this.txtQtd = ((System.Windows.Controls.TextBox)(this.FindName("txtQtd")));
            this.txtbTotalPedido = ((System.Windows.Controls.TextBlock)(this.FindName("txtbTotalPedido")));
            this.btnInsertItem = ((System.Windows.Controls.Button)(this.FindName("btnInsertItem")));
            this.gridAqui = ((System.Windows.Controls.Grid)(this.FindName("gridAqui")));
            this.ListPedido = ((System.Windows.Controls.ListBox)(this.FindName("ListPedido")));
            this.btnRemover = ((System.Windows.Controls.Button)(this.FindName("btnRemover")));
        }
    }
}

