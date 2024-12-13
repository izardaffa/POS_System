package com.pos;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Produk> daftarProduk = new ArrayList<>();
        
        // Tambahkan produk contoh
        daftarProduk.add(new ProdukEceran(1, "Sabun", 5000, "Pcs", 100));
        daftarProduk.add(new ProdukKemasan(2, "Minyak Goreng", 20000, "Bimoli", 100));

        List<Produk> keranjangBelanja = new ArrayList<>();
        boolean belanjaLagi = true; 

        System.out.println("\n=== Daftar Produk ===");
        for (Produk produk : daftarProduk) {
            System.out.println(produk);
        }

        while (belanjaLagi) {
            System.out.print("\nMasukkan ID produk yang ingin dibeli: ");
            int idProduk = scanner.nextInt();

            Produk produkDipilih = daftarProduk.stream().filter(p -> p.getId() == idProduk).findFirst().orElse(null);
            if (produkDipilih != null) {
                keranjangBelanja.add(produkDipilih);
                System.out.println("Produk ditambahkan: " + produkDipilih.getNama());
            } else {
                System.out.println("Produk tidak ditemukan.");
            }

            System.out.print("Ingin menambah produk lain? (y/n): ");
            belanjaLagi = scanner.next().equalsIgnoreCase("y");
        }

        double totalPembayaran = keranjangBelanja.stream().mapToDouble(Produk::getHarga).sum();
        System.out.println("\nTotal pembayaran: " + totalPembayaran);
        
        System.out.println("\n");
        //Nama pengguna
        List<User> userList = new ArrayList<>();  
        userList.add(new Admin("admin", "admin123", "SuperAdmin"));  
        userList.add(new Pegawai("pegawai", "orangrajin", "Kasir"));  

        //Login
        System.out.println("=== Login ===");  
        System.out.print("Masukkan username: ");  
        String username = scanner.next();  
        System.out.print("Masukkan password: ");  
        String password = scanner.next();  

        User currentUser = null;  
        for (User user : userList) {  
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {  
                currentUser = user;  
                break;  
            }  
        }  

        if (currentUser != null) {  
            System.out.println("Login berhasil! Selamat datang, " + currentUser.getUsername() + ".");
            System.out.println("");
            currentUser.displayInfo();   
        } else {  
            System.out.println("Login gagal! Username atau password salah.");  
            return;   
        } 
        
        System.out.println("\nPilih metode pembayaran:");
        System.out.println("1. Cash");
        System.out.println("2. QRIS");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();

        Pembayaran pembayaran;
        switch (pilihan) {
            case 1:
                System.out.println("\n=== Pembayaran Cash ===");
                pembayaran = new PembayaranCash(1, 20241213, totalPembayaran);
                pembayaran.bayar();
                break;
            case 2:
                System.out.println("\n=== Pembayaran QRIS ===");
                pembayaran = new PembayaranQris(2, 20241213, totalPembayaran, "Bank BNI");
                pembayaran.bayar();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
        
    }
}