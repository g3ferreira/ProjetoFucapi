﻿#pragma checksum "C:\ProjetoFucapi\SqLiteTeste\SqLiteTeste\MainPage.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "5DCF2244F380F41147669EFDD9ACB786"
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
    
    
    public partial class MainPage : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal System.Windows.Controls.StackPanel TitlePanel;
        
        internal System.Windows.Controls.Grid ContentPanel;
        
        internal System.Windows.Controls.TextBox txLogin;
        
        internal System.Windows.Controls.TextBlock txtbNome;
        
        internal System.Windows.Controls.TextBox txtSenha;
        
        internal System.Windows.Controls.Button btnLogar;
        
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
            System.Windows.Application.LoadComponent(this, new System.Uri("/SqLiteTeste;component/MainPage.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.TitlePanel = ((System.Windows.Controls.StackPanel)(this.FindName("TitlePanel")));
            this.ContentPanel = ((System.Windows.Controls.Grid)(this.FindName("ContentPanel")));
            this.txLogin = ((System.Windows.Controls.TextBox)(this.FindName("txLogin")));
            this.txtbNome = ((System.Windows.Controls.TextBlock)(this.FindName("txtbNome")));
            this.txtSenha = ((System.Windows.Controls.TextBox)(this.FindName("txtSenha")));
            this.btnLogar = ((System.Windows.Controls.Button)(this.FindName("btnLogar")));
        }
    }
}

