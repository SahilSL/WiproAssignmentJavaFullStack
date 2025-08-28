const mysql2 = require('mysql2');
const readline = require('readline');

// MySQL Connection

//database query
//CREATE DATABASE stock_market;

//USE stock_market;

// CREATE TABLE stocks (
//  id INT AUTO_INCREMENT PRIMARY KEY,
//  symbol VARCHAR(10) NOT NULL,
//  companyName VARCHAR(100) NOT NULL,
//  price DECIMAL(10,2) NOT NULL,
//  volume INT NOT NULL
// );



const connection = mysql2.createConnection({
  host: 'localhost',
  user: 'root',     
  password: 'Sahil@2502',  
  database: 'stock_market'
});



connection.connect((err) => {
  if (err) {
    console.error('Error connecting to database:', err.message);
    process.exit(1); //immediately stops the program and exits the process
    //1 means error
    //0 means success
  }
  console.log('Connected to MySQL database.');
  showMenu();
});



//This initializes a readline interface that reads from the terminal ...standard input and output.
const readl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});





// This is menu
function showMenu() {
  console.log(`
Stock Market Management System
-------------------------------
1. Add Stock
2. View All Stocks
3. View Stock by ID
4. Update Stock Price & Volume
5. Delete Stock
6. Exit
`);

//switch to navigate to different menu options
//readl.question() waits for user input 
  readl.question('Enter your choice: ', (choice) => {
    switch (choice.trim()) {
      case '1':
        addStock();
        break;
      case '2':
        viewAllStocks();
        break;
      case '3':
        viewStockById();
        break;
      case '4':
        updateStock();
        break;
      case '5':
        deleteStock();
        break;
      case '6':
        console.log('Exiting...');
        connection.end();
        readl.close();
        break;
      default:
        console.log('Invalid choice. Try again.'); // if user input is wrong 
        showMenu();
    }
  });
}

// Add Stock Function
function addStock() {
    // here symbol is nothing but short form
  readl.question('Enter Stock Symbol: ', (symbol) => {
    //if no input then----
    if (!symbol.trim()) return retry('Symbol cannot be empty.', addStock);


    // for company name
    readl.question('Enter Company Name: ', (companyName) => {
        // if no input for company
      if (!companyName.trim()) return retry('Company name cannot be empty.', addStock);


        // for PRICE and take only price in positive, no -ve price allowed
      readl.question('Enter Price: ', (price) => {
                if (isNaN(price) || price <= 0) return retry('Invalid price.', addStock);


        // this is for volume
         readl.question('Enter Volume: ', (volume) => {
            //if no input
            if (isNaN(volume) || volume <= 0) return retry('Invalid volume.', addStock);





          connection.query(
            'INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)',
            [symbol, companyName, parseFloat(price), parseInt(volume)],
            //[symbol, companyName, price, volume],  // this need to chanhe, it is ot taking value properly
            (err) => {
              if (err) return console.error('Error adding stock:', err.message);
              console.log('Stock added successfully!');
              showMenu();
            }
          );
        });
      });
    });
  });
}




// view all stocks
function viewAllStocks() {
  connection.query('SELECT * FROM stocks', (err, results) => {
    if (err) return console.error('Error in fetching stocks: ', err.message);

    if (results.length === 0) {
      console.log('No stocks found.');
    } else {
      results.forEach((stock) => {
        console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
      });
    }
    showMenu();  // this is for, once work of function is done then is showMenu(), automatically show all, the menus again
  });
}





// view stock by id
function viewStockById() {
  readl.question('Enter Stock ID: ', (id) => {
    if (isNaN(id)) return retry('Invalid ID.', viewStockById);

    connection.query('SELECT * FROM stocks WHERE id = ?', [id], (err, results) => {
      if (err) return console.error('Error fetching stock:', err.message);

      if (results.length === 0) {
        console.log('Stock not found.');
      } else {
        const stock = results[0];
        console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
      }
      showMenu();
    });
  });
}



// update Stock - only volume and price
function updateStock() {
  readl.question('Enter Stock ID: ', (id) => {
       if (isNaN(id)) return retry('Invalid ID.', updateStock);

    readl.question('Enter New Price: ', (price) => {
      if (isNaN(price) || price <= 0) return retry('Invalid price.', updateStock);

      readl.question('Enter New Volume: ', (volume) => {
        if (isNaN(volume) || volume <= 0) return retry('Invalid volume.', updateStock);

        connection.query(
          'UPDATE stocks SET price = ?, volume = ? WHERE id = ?',
          [parseFloat(price), parseInt(volume), id],
          (err, result) => {
            if (err) return console.error('Error updating stock:', err.message);
            if (result.affectedRows === 0) {
              console.log('Stock not found.');
            } else {
              console.log('Stock updated successfully.');
            }
            showMenu();
          }
        );
      });
    });
  });
}



// deleting the stock
function deleteStock() {
  readl.question('Enter Stock ID to delete: ', (id) => {
    if (isNaN(id)) 
        return retry('Invalid ID.', deleteStock);

    connection.query('DELETE FROM stocks WHERE id = ?', [id], (err, result) => {
      if (err) return console.error('Error deleting stock:', err.message);

      if (result.affectedRows === 0) {
        console.log('Stock not found.');
      } else {
        console.log('Stock deleted successfully.');
      }
      showMenu();
    });
  });
}

// Retry Helper
//Show an error, then restart the same function so the user can try again
function retry(message, callback) {
  console.log(message);
  callback(); //Re-invokes the function that was passed in as callback (in above function line addstock....)
}
