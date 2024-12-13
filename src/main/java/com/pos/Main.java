package com.pos;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produk> daftarProduk = new ArrayList<>();

        // Tambahkan produk contoh
        daftarProduk.add(new ProdukEceran(1, "Sabun", 5000, "Pcs", 100));
        daftarProduk.add(new ProdukKemasan(2, "Minyak Goreng", 20000, 2, "Bimoli"));

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