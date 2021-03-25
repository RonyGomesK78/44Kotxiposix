/**
 * Determine the location of an item in the array
 */
exports.indexOf = function(arr, item) {

    var num = -1;

    arr.forEach(function(element, index){
       if(element == item){
            num = index;
       }
    });
    return num;
    //return arr.indexOf(item);
};

/**
 * Sum the items of an array
 */
exports.sum = function(arr) {
    
    var sum = 0;

    arr.forEach(function(element){
        sum += element;
    });

    return sum;
};

/**
 * Remove all instances of an item from an array
 */
exports.remove = function(arr, item) {

    return arr.filter(function(otherArr){
        return otherArr != item;
    })
};

/**
 * Remove all instances of an item from an array by mutating original array
 */
exports.removeWithoutCopy = function(arr, item) {
    
    /*arr.forEach(function(element, index){
        console.log("i:" +index);
        if (element === item){            
            arr.splice(index, 1);
            index--;
            console.log(index);
        }
    });*/

    for (let index = 0; index < arr.length; index++) {
        var element = arr[index];
        if (element === item){            
            arr.splice(index, 1);
            index--;
        }
        
    }

   // console.log(arr)
    return arr;
};

/**
 * Add an item to the end of the array
 */
exports.append = function(arr, item) {

     arr.push(item);

     return arr;
};

/**
 * Remove the last item of an array
 */
exports.truncate = function(arr) {

    arr.pop();
    return arr;
};

/**
 * Add an item to the beginning of an array
 */
exports.prepend = function(arr, item) {

    arr.unshift(item);
    return arr;
};

/**
 * Remove the first item of an array
 */
exports.curtail = function(arr) {
    arr.shift();
    return arr;
};

/**
 * Join two arrays together
 */
exports.concat = function(arr1, arr2) {

    return arr1.concat(arr2);
};

/**
 * Add an item to an array in the specified position
 */
exports.insert = function(arr, item, index) {

    arr.splice(index, 0, item);
    return arr;
};

/**
 * Count the number of occurrences of an item in an array
 */
exports.count = function(arr, item) {

    var count = 0;

    arr.forEach(element=> {
        if(item === element) count ++;
    });

    return count;
};

/**
 * Find all items which container multiple occurrences in the array
 */
exports.duplicates = function(arr) {

    console.log(arr);
    arr.forEach((element, index) => {
        arr.forEach((innerElement , innerIndex) => {
            if(index != innerIndex && element === innerElement){
                console.log(innerElement);
                return innerElement;
            }
        });
    }); 

};

/**
 * Square each number in the array
 */
exports.square = function(arr) {
};

/**
 * Find all occurrences of an item in an array
 */
exports.findAllOccurrences = function(arr, target) {

};
