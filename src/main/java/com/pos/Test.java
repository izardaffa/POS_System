package com.pos;

import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);

        List<PelangganMember> memberList = new ArrayList<>();
        memberList.add(new PelangganMember(1, "Chisato", "08123456789", 100));
        memberList.add(new PelangganMember(2, "Takina", "08345678912", 200));

        List<User> userList = new ArrayList<>();
        userList.add(new Admin("admin", "admin123", "SuperAdmin"));
        userList.add(new Pegawai("pegawai", "orangrajin", "Kasir"));

        List<Produk> daftarProduk = new ArrayList<>();
        daftarProduk.add(new ProdukEceran(1, "Sabun", 5000, "Pcs", 100));
        daftarProduk.add(new ProdukKemasan(2, "Minyak Goreng", 20000, "Bimoli", 100));
        
        List<LaporanPenjualan> laporanPenjualan = new ArrayList<>();

        User currentUser = null;
        boolean loginSuccess = false;

        while (true) {
            try {
                if (!loginSuccess) {
                    System.out.println("=== Login ===");  
                    System.out.print("Masukkan username (atau ketik 'exit' untuk keluar): ");  
                    String username = Util.stringInput();
                    
                    if (username.equalsIgnoreCase("exit")) {
                        System.out.println("Keluar dari sistem. Terima kasih!");
                        break;
                    }
                    
                    System.out.print("Masukkan password: ");  
                    String password = Util.stringInput();  
            
                    for (User user : userList) {  
                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {  
                            currentUser = user;
                            break;  
                        }  
                    }
                }

                System.out.println();

                if (currentUser != null) {
                    loginSuccess = true;

                    String menu;
                    
                    System.out.println("Login berhasil! Selamat datang, " + currentUser.getUsername() + ".");
                    System.out.println();
                    
                    currentUser.displayInfo();
                    System.out.println();
                    
                    displayMenu("main");

                    System.out.print("Pilih menu: ");
                    menu = Util.stringInput();
                    
                    switch (menu) {
                        case "1":
                            List<Produk> keranjangBelanja = new ArrayList<>();
                            boolean belanjaLagi = true;

                            System.out.println("\n=== Daftar Produk ===");
                            for (Produk produk : daftarProduk) {
                                System.out.println(produk);
                            }

                            while (belanjaLagi) {
                                System.out.print("\nMasukkan ID produk yang ingin dibeli: ");
                                int idProduk = Util.intInput();
                    
                                Produk produkDipilih = daftarProduk.stream().filter(p -> p.getId() == idProduk).findFirst().orElse(null);
                                if (produkDipilih != null) {
                                    keranjangBelanja.add(produkDipilih);
                                    System.out.println("Produk ditambahkan: " + produkDipilih.getNama());
                                } else {
                                    System.out.println("Produk tidak ditemukan.");
                                }
                    
                                System.out.print("Ingin menambah produk lain? (y/n): ");
                                belanjaLagi = Util.stringInput().equalsIgnoreCase("y");
                            }
                    
                            double totalPembayaran = keranjangBelanja.stream().mapToDouble(Produk::getHarga).sum();
                            System.out.println("\nTotal pembayaran: " + totalPembayaran);
                            
                            // Deklarasi pembayaran 
                            Pembayaran pembayaran = null;
                            int pilihan = 0;

                            System.out.println("\nPilih metode pembayaran:");
                            System.out.println("1. Cash");
                            System.out.println("2. QRIS");
                            System.out.print("Pilihan: ");
                            
                            while (pilihan < 1 || pilihan > 2) {
                                pilihan = Util.intInput();

                                // Pembayaran pembayaran;
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
                                        pilihan = 0;
                                        break;
                                }
                            }

                            boolean isMember = false;
                            String noHp = "";

                            System.out.print("Apakah pelanggan member? (y/n)");
                            isMember = Util.stringInput().equalsIgnoreCase("y");

                            if (isMember) {
                                System.out.print("Masukkan nomor hp: ");
                                noHp = Util.stringInput();

                                for (PelangganMember member : memberList) {
                                    if (member.getNoHP().equals(noHp)) {
                                        member.tambahPoint((int)(totalPembayaran / 1000));
                                        System.out.println("Poin member: " + member.getPoint() + " (+"  + (int)(totalPembayaran / 1000) + ")");
                                    }
                                }
                            }

                            laporanPenjualan.add(new LaporanPenjualan(69, "2024-12-15", totalPembayaran, pembayaran));
                            System.out.println("Transaksi berhasil!");
                            Util.lanjutkan();
                            break;
                        case "2":
                            System.out.println("Daftar Pelanggan");
                            break;
                        case "5":
                            System.out.println("\nLaporan Penjualan");
                            for (LaporanPenjualan laporan : laporanPenjualan) {
                                laporan.cetakLaporan();
                            }
                            Util.lanjutkan();
                            break;
                        case "0":
                            System.out.println("Keluar dari sistem. Terima kasih!");
                            loginSuccess = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                            break;
                    }
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }

                System.out.println();
            } catch (Exception e) {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void displayMenu(String x) {
        if (x == "main") {
            String menu[] = {
                "Kasir",
                "Daftar Pelanggan",
                "Daftar Produk",
                "Daftar Pengguna",
                "Laporan Penjualan",
                "Keluar"
            };

            System.out.println("=== Menu Utama ===");
            for (int i = 0; i < menu.length - 1; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.println("0. " + menu[menu.length - 1]);
        } else if (x == "produk") {
            String menu[] = {
                "Tambah Produk",
                "Edit Produk",
                "Hapus Produk"
            };

            System.out.println("=== Manajemen Produk ===");
            for (int i = 0; i < menu.length - 1; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
        }
    }
}
