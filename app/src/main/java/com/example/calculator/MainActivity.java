package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button one=findViewById(R.id.one);
        final TextView input=findViewById(R.id.input);
        final    Button two=findViewById(R.id.two);
        final    Button three=findViewById(R.id.three);
        final    Button four=findViewById(R.id.four);
        final   Button five=findViewById(R.id.five);
        final   Button six=findViewById(R.id.six);
        final   Button seven=findViewById(R.id.seven);
        final  Button eight=findViewById(R.id.eight);
        final    Button nine=findViewById(R.id.nine);
        final    Button zero=findViewById(R.id.zero);
        final    Button plus=findViewById(R.id.plus);
        final    Button minuse=findViewById(R.id.minuse);
        final    Button milti=findViewById(R.id.multi);
        final    Button divide=findViewById(R.id.divide);
        final    Button dot=findViewById(R.id.dot);
        final   Button delete=findViewById(R.id.delete);
        final   Button clear=findViewById(R.id.clear);
        final Button equal=findViewById(R.id.equal);
        final TextView output=findViewById(R.id.output);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+one.getText().toString());
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+two.getText().toString());
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+three.getText().toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+four.getText().toString());
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+five.getText().toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+six.getText().toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+seven.getText().toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+eight.getText().toString());
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+nine.getText().toString());
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+zero.getText().toString());
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+dot.getText().toString());
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+plus.getText().toString());
            }
        });
        minuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+minuse.getText().toString());
            }
        });
        milti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+milti.getText().toString());
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+divide.getText().toString());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().length() > 0) {


                    input.setText(input.getText().toString().substring(0, input.getText().toString().length() - 1));
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formula = input.getText().toString();
                String varabiles = "";
                String operators = "";
                for (int i = 0; i < formula.length(); i++) {
                    char currentChar = formula.charAt(i);
                    if (currentChar == '+' || currentChar == '-' || currentChar == 'X' || currentChar == '/') {
                        if (i < formula.length() - 1) {
                            if (currentChar == '/' && formula.charAt(i + 1) == 0) {
                                output.setText("math error");
                            }
                        }
                        operators =operators+currentChar;
                        varabiles=varabiles+'d';

                    } else {
                        varabiles= varabiles+ currentChar;
                 }
                }
                if (varabiles.charAt(0)=='d') {
                    output.setText("math error");
                }
                int count=0;
                int intial=0;
                float result=0;
               for(int i=0;i<varabiles.length()-1;i++) {
                   if (varabiles.charAt(i) == 'd') {
                       result = Float.parseFloat(formula.substring(0, i));
                       intial=i;
                       break;
                   }
               }
                varabiles=varabiles+'d';
               for(int j=intial+1;j<varabiles.length();j++) {
                   if (varabiles.charAt(j) == 'd') {
                       float rightSide = Float.parseFloat(varabiles.substring(intial + 1, j));
                       switch (operators.charAt(count)) {
                               case '+':
                                   result = result + rightSide;
                                   break;
                               case '-':
                                   result = result - rightSide;
                                   break;
                               case '/':
                                   result = result / rightSide;
                                   break;
                               default:
                                   result = result * rightSide;

                           }
                           count++;
                           intial=j;
                       }

                   }
                input.setText("");
                output.setText(String.valueOf(result));
            }
        });

    }
}
