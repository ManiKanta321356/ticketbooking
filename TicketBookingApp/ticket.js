const app = document.getElementById('app');
const loginScreen = document.getElementById('login-screen');
const seatSelectionScreen = document.getElementById('seat-selection-screen');
const usernameInput = document.getElementById('username');
const seatsContainer = document.getElementById('seats');

const seats = new Array(10).fill(false);
let currentUser = null;

function login() {
  const username = usernameInput.value.trim();
  if (username) {
    currentUser = username;
    displaySeats();
    loginScreen.classList.remove('active');
    seatSelectionScreen.classList.add('active');
  } else {
    alert('Please enter a username');
  }
}

function displaySeats() {
  seatsContainer.innerHTML = '';
  seats.forEach((isBooked, index) => {
    const seatButton = document.createElement('button');
    seatButton.textContent = index + 1;
    seatButton.classList.add(isBooked ? 'booked' : 'available');
    if (!isBooked) {
      seatButton.onclick = () => toggleSeat(index);
    }
    seatsContainer.appendChild(seatButton);
  });
}

function toggleSeat(index) {
  seats[index] = !seats[index];
  displaySeats();
}

function submitBooking() {
    const bookedSeats = seats.map((isBooked, index) => isBooked ? index + 1 : null).filter(seat => seat !== null);
  
    const bookingData = {
      username: currentUser,
      seats: bookedSeats
    };
  
    fetch('/api/book', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(bookingData)
    })
    .then(response => response.json())
    .then(data => {
      alert('Booking Confirmed');
      console.log('Success:', data);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }
  

loginScreen.classList.add('active');