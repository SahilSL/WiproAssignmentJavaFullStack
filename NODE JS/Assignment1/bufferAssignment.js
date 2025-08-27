/*
In JavaScript (browser), we usually work with strings and JSON objects.

But sometimes we need to handle raw binary data (like files, network streams, or images).

In Node.js, this is done using the Buffer class.
*/

let buffer = Buffer.alloc(256);    // buffer of 256 bytes

// Data - student obj
let student1 = { 
    id: 1, 
    name: "Thananya", 
    age: 20, 
    grade: "A" 
};


let student1Str = JSON.stringify(student1); // converting  js object to json string
console.log(student1Str);  //{"id":1,"name":"Thananya","age":20,"grade":"A"}


let bytesWritten = buffer.write(student1Str, "utf8"); // write the string data into the buffer using utf8 encoding and buffer.write() return how many bytes written

console.log(bytesWritten); //47


// prints the number of bytes written
console.log("Bytes written to buffer:", bytesWritten);

//buffer content as string
console.log("Buffer content as string:", buffer.toString("utf8", 0, bytesWritten));
//buffer.toString(encoding, start, end) converts buffer data back into a string and o/p will be the JSON string



// read back and parse JSON
let parsedStudent1 = JSON.parse(buffer.toString("utf8", 0, bytesWritten)); //JSON.parse() converts string back into an object.
console.log(parsedStudent1);

console.log("Parsed Student Data:");
console.log("ID:", parsedStudent1.id);
console.log("Name:", parsedStudent1.name);
console.log("Age:", parsedStudent1.age);
console.log("Grade:", parsedStudent1.grade);

// showing buffer content in Base64 form
console.log("Buffer content in base64:", buffer.toString("base64", 0, bytesWritten));

/*
UTF-8 - the standard encoding for most data.
ASCII - works but limited to simple characters.
Base64 -  encodes binary data into text, safe for transmission.
*/