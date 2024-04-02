package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Graphical_user_interface;

import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Business_logic.OperationsPolynomials;
import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models.Polynomial;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SceneController {

    @FXML
    private Button derivativeButton;

    @FXML
    private Label InvalidInputMessage;

    @FXML
    private Button divisionButton;

    @FXML
    private Button integrationButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button multiplicationButton;

    @FXML
    private Button plusButton;

    @FXML
    private TextField polynomP;

    @FXML
    private TextField polynomQ;

    @FXML
    private TextArea resultTextArea;


    private void displayMessageInvalidPolynomials(Polynomial P, Polynomial Q)
    {
        InvalidInputMessage.setVisible(true);
        if(P.getMonomials()==null)
            if(Q.getMonomials()==null)
                InvalidInputMessage.setText("P and Q are not valid polynomials!");
            else
                InvalidInputMessage.setText("P is not a valid polynomial!");
        else
            InvalidInputMessage.setText("Q is not a valid polynomial!");
    }

    @FXML
    private void onClickAddButton()
    {
        InvalidInputMessage.setVisible(false);
        resultTextArea.setText("");
        Polynomial P = new Polynomial(polynomP.getText());
        Polynomial Q = new Polynomial(polynomQ.getText());
        if(P.getMonomials()!=null&&Q.getMonomials()!=null)
        {
            var result = OperationsPolynomials.add(P,Q);
            resultTextArea.setText(result.toString());
        }
        else
            displayMessageInvalidPolynomials(P,Q);
    }
    @FXML
    private void onClickSubtractButton()
    {
        InvalidInputMessage.setVisible(false);
        resultTextArea.setText("");
        Polynomial P = new Polynomial(polynomP.getText());
        Polynomial Q = new Polynomial(polynomQ.getText());
        if(P.getMonomials()!=null&&Q.getMonomials()!=null)
        {
            var result = OperationsPolynomials.subtract(P,Q);
            resultTextArea.setText(result.toString());
        }
        else
            displayMessageInvalidPolynomials(P,Q);
    }
    @FXML
    private void onClickMultiplyButton()
    {
        InvalidInputMessage.setVisible(false);
        resultTextArea.setText("");
        Polynomial P = new Polynomial(polynomP.getText());
        Polynomial Q = new Polynomial(polynomQ.getText());
        if(P.getMonomials()!=null&&Q.getMonomials()!=null)
        {
            var result = OperationsPolynomials.multiply(P,Q);
            resultTextArea.setText(result.toString());
        }
        else
            displayMessageInvalidPolynomials(P,Q);
    }
    @FXML
    private void onClickDerivateButton()
    {
        InvalidInputMessage.setVisible(false);
        resultTextArea.setText("");
        Polynomial P = new Polynomial(polynomP.getText());
        if(P.getMonomials()!=null)
        {
            var result = OperationsPolynomials.derivate(P);
            resultTextArea.setText(result.toString());
        }
        else
        {
            InvalidInputMessage.setVisible(true);
            InvalidInputMessage.setText("P is not a valid polynomial!");
        }
    }
    @FXML
    private void onClickIntegrateButton()
    {
        InvalidInputMessage.setVisible(false);
        resultTextArea.setText("");
        Polynomial P = new Polynomial(polynomP.getText());
        if(P.getMonomials()!=null)
        {
            if(!P.isZero())
            {
                var result = OperationsPolynomials.integrate(P);
                resultTextArea.setText(result+"+C");
            }
            else
                resultTextArea.setText("C");
        }
        else
        {
            InvalidInputMessage.setVisible(true);
            InvalidInputMessage.setText("P is not a valid polynomial!");
        }
    }
    @FXML
    private void onClickDivisionButton()
    {
        InvalidInputMessage.setVisible(false);
        resultTextArea.setText("");
        Polynomial P = new Polynomial(polynomP.getText());
        Polynomial Q = new Polynomial(polynomQ.getText());
        if(P.getMonomials()!=null&&Q.getMonomials()!=null)
        {
            if(Q.isZero()) {
                InvalidInputMessage.setVisible(true);
                InvalidInputMessage.setText("The denominator cannot be 0!");
            }
            else {
                var result = OperationsPolynomials.divide(P, Q);
                var quotient = result[0];
                var remainder = result[1];
                String string = "";
                string += "Quotient:\n" + quotient.toString() + "\nRemainder:\n" + remainder.toString();
                resultTextArea.setText(string);
            }
        }
        else
            displayMessageInvalidPolynomials(P,Q);
    }
}
