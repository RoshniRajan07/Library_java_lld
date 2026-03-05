package com.kce.service;

import java.util.ArrayList;
import com.kce.model.Book;
import com.kce.model.Member;
import com.kce.model.Borrowrecords;

public class Service {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Borrowrecords> records = new ArrayList<>();

    public void addBook(int id,String title,String author,int copies){

        Book b = new Book();
        b.setBookId(id);
        b.setTitle(title);
        b.setAuthor(author);
        b.setCopies(copies);

        books.add(b);

        System.out.println("Book added");
    }


    public void registerMember(int id,String name){

        Member m = new Member();
        m.setMemberId(id);
        m.setName(name);

        members.add(m);

        System.out.println("Member registered");
    }
    public void borrowBook(int memberId,int bookId,int day){

        int count = 0;

        for(Borrowrecords r : records){
            if(r.getMemberId()==memberId)
                count++;
        }

        if(count>=3){
            System.out.println("Max 3 books allowed");
            return;
        }

        for(Book b : books){

            if(b.getBookId()==bookId && b.getCopies()>0){

                Borrowrecords br = new Borrowrecords();
                br.setMemberId(memberId);
                br.setBookId(bookId);
                br.setBorrowDay(day);

                records.add(br);

                b.setCopies(b.getCopies()-1);

                for(Member m : members){
                    if(m.getMemberId()==memberId)
                        m.setTotalBorrowed(m.getTotalBorrowed()+1);
                }

                System.out.println("Book borrowed");
                return;
            }
        }

        System.out.println("Book not available");
    }

    public void returnBook(int memberId,int bookId,int day){

        for(Borrowrecords r : records){

            if(r.getMemberId()==memberId && r.getBookId()==bookId){

                int diff = day - r.getBorrowDay();

                if(diff>14){
                    int fine = (diff-14)*2;
                    System.out.println("Fine: Rs."+fine);
                }

                for(Book b : books){
                    if(b.getBookId()==bookId)
                        b.setCopies(b.getCopies()+1);
                }

                records.remove(r);

                System.out.println("Book returned");
                return;
            }
        }

        System.out.println("Record not found");
    }

    public void searchBook(String key){

        for(Book b : books){

            if(b.getTitle().contains(key) || b.getAuthor().contains(key))
                System.out.println(b.getBookId()+" "+b.getTitle()+" "+b.getAuthor());
        }
    }

    public void memberReport(int memberId){

        System.out.println("Books borrowed by member "+memberId);

        for(Borrowrecords r : records){

            if(r.getMemberId()==memberId)
                System.out.println("Book ID: "+r.getBookId());
        }
    }

    public void bookReport(int bookId){

        System.out.println("Members who borrowed book "+bookId);

        for(Borrowrecords r : records){

            if(r.getBookId()==bookId)
                System.out.println("Member ID: "+r.getMemberId());
        }
    }

    public void topBorrowers(){

        members.sort((a,b)->b.getTotalBorrowed()-a.getTotalBorrowed());

        for(Member m : members)
            System.out.println(m.getMemberId()+" "+m.getName()+" Borrowed:"+m.getTotalBorrowed());
    }
}