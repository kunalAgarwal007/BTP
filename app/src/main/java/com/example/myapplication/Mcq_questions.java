package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mcq_questions extends AppCompatActivity {
    TextView question;
    Button yes,no;
    Binarytree binarytree1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcq);
        question=findViewById(R.id.question);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

        Binarytree binarytree=new Binarytree("Are you suffering from joint pain ?");
        binarytree.left =new Binarytree("is the pain symmetric ?") ;
        binarytree.right =new Binarytree("false") ;
        binarytree.left.left= new Binarytree("true");
        binarytree.left.right=new Binarytree("Do you experience inflammation ?");
        binarytree.left.right.left= new Binarytree("true");
        binarytree.left.right.right=new Binarytree("Do you experience morning stiffness ?");

        binarytree.left.right.right.left=new Binarytree("Positive . Does stiffness lasts " +
                "for more than 30 mins");

        binarytree.left.right.right.right=new Binarytree("false");
        binarytree.left.right.right.left.left=new Binarytree("Positive w/RA");
        binarytree.left.right.right.left.right=new Binarytree("Positive w/OA");
         binarytree1=binarytree;

        reload();
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binarytree1=binarytree1.left;
                reload();

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binarytree1=binarytree1.right;
                reload();

            }
        });


    }

    private void reload() {
        if(binarytree1.question=="true"){

        }
        else if(binarytree1.question=="false"){

        }
        else{
            question.setText(binarytree1.question);
        }
    }
}