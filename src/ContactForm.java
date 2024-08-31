package myProject;

import javax.swing.*;
import java.awt.*; // библиотека создание кнопок, радиокнопок, надписей, контейнеров
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame { // наследуем класс JFrame
    private JTextField name_field, email_field, phone_field;
    private JRadioButton male, female;
    private JCheckBox check;

    public  ContactForm(){
        super("Контактная форма"); // вывоится сверху окна
        this.setBounds(300,300,350, 200); //можно указать где располагается приложение x,y и размеры окна
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //при нажатии на крестик - приложение остановиться

        Container container = super.getContentPane(); // создание контейнера
        container.setLayout(new GridLayout(6,2,2,10)); //система расположения объектов - GridLayout сетка - ряды, столбцы, ячейки для помещения объектов

        JLabel name = new JLabel("Введите имя:");
         name_field = new JTextField("", 1);
        JLabel email = new JLabel("Введите email:");
         email_field = new JTextField("@", 1);
        JLabel phone = new JLabel("Введите номер телефона:");
         phone_field = new JTextField("+7", 1);

        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);
        container.add(phone);
        container.add(phone_field);

        male = new JRadioButton("Мужской");
        female = new JRadioButton("Женский");
        check = new JCheckBox("Согласен?", false);
        JButton send_button = new JButton("Отправить заявку");

        male.setSelected(true);

        container.add(male);
        container.add(female);
        container.add(check);
        container.add(send_button);

        ButtonGroup group_gender = new ButtonGroup(); // исключить двойной выбор
        group_gender.add(male);
        group_gender.add(female);

        send_button.addActionListener(new ButtonEvent());
    }

    class ButtonEvent implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) { // срабатывает каждый раз при нажатии на кнопку
            String name = name_field.getText();
            String email = email_field.getText();
            String phone = phone_field.getText();

            String isMale = male.isSelected()? "Мужской":"Женский";

            boolean checkBox = check.isSelected();
            JOptionPane.showMessageDialog(null, "Ваша почта: " + email + "\nВаш телефон: "
                    + phone + "\nВащ пол: " + isMale + "\n"
                    + (checkBox? "Заявка отправлена, ожидайте звонка в течение двух часов"
                    : "Согласие на отправку заявки не получили, заявка не отправлена"),
                    "Привет, " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
