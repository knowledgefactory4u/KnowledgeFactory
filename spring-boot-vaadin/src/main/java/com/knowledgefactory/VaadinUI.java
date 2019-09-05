package com.knowledgefactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class VaadinUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7896040466986437670L;



	@Autowired
	private UserService service;

	

	private Binder<User> binder = new Binder<>(User.class);

	private Grid<User> grid = new Grid<User>(User.class);
	private TextField name = new TextField("Name");
	private TextField mail = new TextField("Mail");
	private Button save = new Button("Save");

	@Override
	protected void init(VaadinRequest request) {
		updateGrid();
		grid.setColumns("name", "mail");

		binder.bindInstanceFields(this);

		VerticalLayout layout = new VerticalLayout(grid, name, mail, save);
		setContent(layout);
	}

	private void updateGrid() {
		List<User> users = service.findAll();
		grid.setItems(users);
		setFormVisible(false);
	}

	private void setFormVisible(boolean visible) {
		name.setVisible(visible);
		mail.setVisible(visible);
		save.setVisible(visible);
	}

}
