package com.celinio.firstcelltable.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;

public class CellTableExample2 implements EntryPoint {

	  // A simple data type that represents a contact.
	  private static class Contact {
	    private final String address;
	    private final String name;
	    private final Date birthday;
	    private final String ville;

	    
	    public Contact(String name, Date birthday, String address, String ville) {
		      this.name = name;
		      this.birthday = birthday;
		      this.address = address;
		      this.ville = ville;
		    }
	  }

	  // The list of data to display.
			  private static final List<Contact> CONTACTS = Arrays.asList(
				      new Contact("Marc", new Date(70, 3, 21), "34 av Charles de Gaulle", "Paris"), 
				      new Contact("Delphine", new Date(70, 2, 6), "12 rue de Nice", "Marseille"), 
				      new Contact("Joe", new Date(85, 3, 22), "56 impasse Jeanne", "Reims"), 
				      new Contact("Eric", new Date(72, 4, 22), "14 av de Lome", "Rennes"), 
				      new Contact("Celine", new Date(45, 5, 4), "567 rue Auguste Briand", "Rouen"), 
				      new Contact("Suzie", new Date(60, 6, 9), "98 av du Senat", "Quimper"), 
				      new Contact("Nom1", new Date(61, 5, 1), "2 av du combat", "Volvic"),
				      new Contact("Nom2", new Date(62, 4, 22), "55 av du renard", "Dax"),
				      new Contact("Nom3", new Date(63, 3, 3), "9 rue du Chat", "Issy Les Moulineaux"),
				      new Contact("Nom4", new Date(64, 2, 22), "44 av du Senat", "Guyancourt"),
				      new Contact("Nom5", new Date(65, 1, 22), "4 av de la Table", "Agen"),
				      new Contact("Nom6", new Date(66, 12, 22), "9 av du Port", "Puteaux"),
				      new Contact("Nom7", new Date(67, 6, 13), "22 av du Senat", "Montreuil"),
				      new Contact("Nom8", new Date(68, 3, 16), "34 av des Hautes Eaux", "Paris"),
				      new Contact("Nom9", new Date(69, 6, 22), "98 av du tage", "Brest"),
				      new Contact("Nom10", new Date(70, 4, 9), "98 av du Ruisseau", "Saint-Etienne"),
				      new Contact("Nom11", new Date(71, 6, 18), "98 av du Mali", "Creteil"),
				      new Contact("Nom12", new Date(72, 7, 22), "6 av du Siege", "Rungis"),
				      new Contact("Nom13", new Date(73, 6, 2), "11 av du Point", "Courbevoie"),
				      new Contact("Nom14", new Date(74, 8, 18), "33 av du Fleuve", "Nogent"),
				      new Contact("Nom15", new Date(75, 4, 10), "68 av du rhin", "Poitiers"),
				      new Contact("Nom16", new Date(76, 9, 12), "98 av du Senat", "Mulhouse"),
				      new Contact("Nom17", new Date(77, 6, 11), "955 rue du serpent", "Strasbourg"),
				      new Contact("Nom18", new Date(78, 8, 2), "9 av du Senat", "Saint-Denis"),
				      new Contact("Nom19", new Date(79, 6, 22), "3 av du Tigre", "Bussy"),
				      new Contact("Nom20", new Date(80, 6, 18), "98 av du Senat", "Fontenay"),
				      new Contact("Nom21", new Date(81, 7, 27), "98 av du Marche", "Versailles"),
				      new Contact("Nom22", new Date(82, 2, 14), "7 av du Senat", "Auteuil"),
				      new Contact("Nom23", new Date(83, 1, 13), "44 rue du Ciel", "Creil"),
				      new Contact("Nom24", new Date(84, 3, 11), "21 av du Senat", "Nice"),
				      new Contact("Nom25", new Date(85, 6, 1), "6 rue du Senat", "Lille"),
				      new Contact("Nom26", new Date(86, 5, 22), "55 rue Crozatier", "Nantes"),
				      new Contact("Nom27", new Date(87, 9, 8), "84 av du Senat", "Bordeaux"),
				      new Contact("Nom28", new Date(88, 4, 4), "8 av du Senat", "Valence"),
				      new Contact("Nom29", new Date(89, 12, 9), "22 av du Senat", "Paris"),
				      new Contact("Nom30", new Date(90, 6, 29), "65 av du Pont", "Bonneuil"),
				      new Contact("Nom31", new Date(91, 1, 20), "39 av du Port", "Houilles"),
				      new Contact("Nom32", new Date(92, 3, 17), "2 av du Senat", "Grenoble"),
				      new Contact("Nom33", new Date(93, 6, 11), "1 av de Paris", "Orleans"),
				      new Contact("Nom33", new Date(94, 6, 11), "3 impasse Dove", "Le Havre"),
				      new Contact("Nom33", new Date(95, 6, 11), "4 rue de la Croix", "Stains"),
				      new Contact("Nom33", new Date(96, 6, 11), "7 av de Berny", "La Rochelle"),
				      new Contact("Rico", new Date(84, 6, 6),"90 allee des Saules", "Sevres"));

	  public void onModuleLoad() {

	    // Create a CellTable.
	    final CellTable<Contact> table = new CellTable<Contact>();

	    // Create name column.
	    TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
	      @Override
	      public String getValue(Contact contact) {
	        return contact.name;
	      }
	    };

	    // Make the name column sortable.
	    //nameColumn.setSortable(true);

	    // Create address column.
	    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
	      @Override
	      public String getValue(Contact contact) {
	        return contact.address;
	      }
	    };
	    
	    // Add a date column to show the birthday.
	    DateCell dateCell = new DateCell();
	    Column<Contact, Date> dateColumn = new Column<Contact, Date>(dateCell) {
	      @Override
	      public Date getValue(Contact object) {
	        return object.birthday;
	      }
	    };
	   
	 // Add a text column to show the address.
	    TextColumn<Contact> villeColumn = new TextColumn<Contact>() {
	      @Override
	      public String getValue(Contact object) {
	        return object.ville;
	      }
	    };
	    villeColumn.setSortable(true);
	   

	    // Add the columns.
	    table.addColumn(nameColumn, "Nom");
	    table.addColumn(addressColumn, "Adresse");
	    table.addColumn(dateColumn, "Anniversaire");
	    table.addColumn(villeColumn, "Ville");

	    // Set the total row count. You might send an RPC request to determine the
	    // total row count.
	    table.setRowCount(CONTACTS.size(), true);

	    // Set the range to display. In this case, our visible range is smaller than
	    // the data set.
	    table.setVisibleRange(0, 10);

	    // Create a data provider.
	    AsyncDataProvider<Contact> dataProvider = new AsyncDataProvider<Contact>() {
	      @Override
	      protected void onRangeChanged(HasData<Contact> display) {
	        final Range range = display.getVisibleRange();

	        // Get the ColumnSortInfo from the table.
	        final ColumnSortList sortList = table.getColumnSortList();

	        // This timer is here to illustrate the asynchronous nature of this data
	        // provider. In practice, you would use an asynchronous RPC call to
	        // request data in the specified range.
	        new Timer() {
	          @Override
	          public void run() {
	            int start = range.getStart();
	            int end = start + range.getLength();
	            // This sorting code is here so the example works. In practice, you
	            // would sort on the server.
	            Collections.sort(CONTACTS, new Comparator<Contact>() {
	              public int compare(Contact o1, Contact o2) {
	                if (o1 == o2) {
	                  return 0;
	                }

	                // Compare the ville columns.
	                int diff = -1;
	                if (o1 != null) {
	                  diff = (o2 != null) ? o1.ville.compareTo(o2.ville) : 1;
	                }
	                return sortList.get(0).isAscending() ? diff : -diff;
	              }
	            });
	            List<Contact> dataInRange = CONTACTS.subList(start, end);

	            // Push the data back into the list.
	            table.setRowData(start, dataInRange);
	          }
	        }.schedule(2000);
	      }
	    };

	    // Connect the list to the data provider.
	    dataProvider.addDataDisplay(table);

	    
	    SimplePager pager = new SimplePager();
	    pager.setDisplay(table);
	    
	    // Add a ColumnSortEvent.AsyncHandler to connect sorting to the
	    // AsyncDataPRrovider.
	    AsyncHandler columnSortHandler = new AsyncHandler(table);
	    table.addColumnSortHandler(columnSortHandler);

	    // We know that the data is sorted alphabetically by default.
	    table.getColumnSortList().push(nameColumn);

	    
	    HorizontalPanel hp = new HorizontalPanel();
	    
	    VerticalPanel vp = new VerticalPanel();
	    vp.add(table);
	    vp.add(pager);	 
	    
	    hp.setWidth("100%");
	    hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    hp.add(vp);
	  
	    // Add it to the root panel.
	    RootPanel.get().add(hp);
	  }
	}
