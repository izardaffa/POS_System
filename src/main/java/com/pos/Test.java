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

        int memberIdCounter = memberList.size() + 1;

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

                            do {
                                System.out.print("\nApakah pelanggan member? (y/n) ");
                                isMember = Util.stringInput().equalsIgnoreCase("y");

                                if (isMember) {
                                    System.out.print("Masukkan nomor hp: ");
                                    noHp = Util.stringInput();
                                    boolean isFound = false;

                                    for (PelangganMember member : memberList) {
                                        if (member.getNoHP().equals(noHp)) {
                                            member.tambahPoint((int)(totalPembayaran / 1000));
                                            isFound = true;
                                            isMember = false;

                                            System.out.println("Poin member: " + member.getPoint() + " (+"  + (int)(totalPembayaran / 1000) + ")");
                                        }
                                    }

                                    if (!isFound) {
                                        System.out.println("Member tidak ditemukan.");
                                    }
                                }
                            } while (isMember);

                            laporanPenjualan.add(new LaporanPenjualan(69, "2024-12-15", totalPembayaran, pembayaran));
                            System.out.println("Transaksi berhasil!");
                            Util.lanjutkan();
                            break;
                        case "2":
                            System.out.println("\n=== Daftar Pelanggan ===\n");

                            System.out.println("No | Nama | No HP | Point");
                            for (PelangganMember member : memberList) {
                                System.out.println(member.toString());
                            }
                            System.out.println();

                            displayMenu("pelanggan");
                            System.out.print("Pilih menu: ");
                            String menuPelanggan = Util.stringInput();

                            switch (menuPelanggan) {
                                case "1":
                                    System.out.print("Masukkan nama: ");
                                    String nama = Util.stringInput();
                                    System.out.print("Masukkan no HP: ");
                                    String noHP = Util.stringInput();

                                    memberList.add(new PelangganMember(memberIdCounter, nama, noHP, 0));
                                    memberIdCounter++;
                                    System.out.println("Pelanggan berhasil ditambahkan!");
                                    Util.lanjutkan();
                                    break;
                                case "2":
                                    int idPelanggan;
                                    boolean isEdited = false;

                                    System.out.print("Masukkan ID pelanggan: ");
                                    idPelanggan = Util.intInput();

                                    for (PelangganMember member : memberList) {
                                        if (member.getId() == idPelanggan) {
                                            boolean isPhoneAvailable = true;
                                            String namaBaru;
                                            String noHPBaru;

                                            System.out.print("Masukkan nama: ");
                                            namaBaru = Util.stringInput();
                                            
                                            System.out.print("Masukkan no HP: ");
                                            noHPBaru = Util.stringInput();

                                            for (PelangganMember member2 : memberList) {
                                                if (member2.getNoHP().equals(noHPBaru)) {
                                                    System.out.println("No HP sudah digunakan.");
                                                    isPhoneAvailable = false;
                                                    break;
                                                }
                                            }

                                            if (isPhoneAvailable) {
                                                if (!namaBaru.isEmpty()) {
                                                    member.setNama(namaBaru);
                                                }

                                                if (!noHPBaru.isEmpty()) {
                                                    member.setNoHP(noHPBaru);
                                                }

                                                System.out.println("Pelanggan berhasil diubah!");
                                                isEdited = true;
                                            }

                                            break;
                                        }
                                    }

                                    if (!isEdited) {
                                        System.out.println("Pelanggan tidak ditemukan.");
                                    }

                                    Util.lanjutkan();
                                    break;
                                case "3":
                                    int idPelangganHapus;
                                    boolean isDeleted = false;
                                    
                                    System.out.print("Masukkan ID pelanggan: ");
                                    idPelangganHapus = Util.intInput();

                                    for (PelangganMember member : memberList) {
                                        if (member.getId() == idPelangganHapus) {
                                            memberList.remove(member);
                                            System.out.println("Pelanggan berhasil dihapus!");
                                            isDeleted = true;
                                            Util.lanjutkan();
                                        }
                                    }

                                    if (!isDeleted) {
                                        System.out.println("Pelanggan tidak ditemukan.");
                                        Util.lanjutkan();
                                    }
                                    break;
                                case "0":
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid.");
                                    break;
                            }
                            break;
                        case "3":
                            System.out.println("\n=== Daftar Produk ===\n");

                            System.out.println("No | Nama | No HP | Point");
                            for (PelangganMember member : memberList) {
                                System.out.println(member.toString());
                            }
                            System.out.println();

                            displayMenu("produk");
                            System.out.print("Pilih menu: ");
                            String menuProduk = Util.stringInput();
                            break;
                        case "4":
                            System.out.println("\n=== Daftar Pengguna ===\n");

                            for (PelangganMember member : memberList) {
                                System.out.println(member.toString());
                            }
                            System.out.println();

                            displayMenu("pengguna");
                            System.out.print("Pilih menu: ");
                            String menuPengguna = Util.stringInput();
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
                System.out.println("Error: Input tidak sesuai.");
                Util.lanjutkan();
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
        } else if (x == "pelanggan") {
            String menu[] = {
                "Tambah Pelanggan",
                "Edit Pelanggan",
                "Hapus Pelanggan",
                "Kembali"
            };

            System.out.println("=== Manajemen Pelanggan ===");
            for (int i = 0; i < menu.length - 1; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.println("0. " + menu[menu.length - 1]);
        } else if (x == "produk") {
            String menu[] = {
                "Tambah Produk",
                "Edit Produk",
                "Hapus Produk",
                "Kembali"
            };

            System.out.println("=== Manajemen Produk ===");
            for (int i = 0; i < menu.length - 1; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.println("0. " + menu[menu.length - 1]);
        } else if (x == "pengguna") {
            String menu[] = {
                "Tambah Pengguna",
                "Edit Pengguna",
                "Hapus Pengguna",
                "Kembali"
            };

            System.out.println("=== Manajemen Pengguna ===");
            for (int i = 0; i < menu.length - 1; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.println("0. " + menu[menu.length - 1]);
        }
    }
}
