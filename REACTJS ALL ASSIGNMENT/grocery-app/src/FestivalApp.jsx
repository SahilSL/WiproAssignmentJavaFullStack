//Assignment 20
// FestivalApp.jsx
import React, { useEffect, useState } from 'react';

const FestivalApp = () => {
  /**
   * Q3: Festival name state
   * Default festival is 'Diwali'
   * When this state changes, effects depending on it will re-run
   */
  const [festival, setFestival] = useState('Diwali');

  /**
   * Q4: Countdown timer state
   * Starts at 5 seconds
   */
  const [secondsLeft, setSecondsLeft] = useState(5);

  /**
   * Q1: useEffect with NO dependency array
   * This will run on every render (initial + every re-render)
   * Useful for logging or tracking updates
   */
  useEffect(() => {
    console.log("Festival App Rendered");
  });

  /**
   * Q2: useEffect with EMPTY dependency array []
   * This will run ONLY ONCE when the component is first mounted
   * Useful for one-time setup like alerts or API calls
   */
  useEffect(() => {
    alert("Welcome to Diwali Festival App");
  }, []);   // Empty array → run once

  /**
   * Q3: useEffect that tracks when `festival` changes
   * This effect will ONLY run when the `festival` value is updated
   * Helps track specific state changes
   */
 useEffect(() => {
  console.log(`Festival changed to ${festival}. Seconds left: ${secondsLeft}`);
}, [festival, secondsLeft]); // Only runs when festival changes

  /**
   * Q4: useEffect that handles the countdown timer
   * Starts a timer that decreases `secondsLeft` every second
   * Also includes CLEANUP to clear the timer when the component unmounts
   */
  useEffect(() => {
    const timer = setInterval(() => {
      setSecondsLeft((prev) => prev > 0 ? prev - 1 : 0);
    }, 1000);

    // Cleanup when component unmounts
    return () => {
      clearInterval(timer);
    };
  }, []);

  /**
   * Q5: useEffect with MULTIPLE dependencies
   * Runs whenever EITHER `festival` OR `secondsLeft` changes
   * Useful when multiple pieces of state need to be tracked together
   */
  useEffect(() => {
    console.log(`Festival or countdown changed → ${festival}, Seconds left: ${secondsLeft}`);
  }, [festival, secondsLeft]);

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h1>{festival} Festival App</h1>
      <h2>Countdown: {secondsLeft} seconds</h2>
      <div style={{ marginTop: '20px' }}>
        <button onClick={() => setFestival('Holi')}>Change to Holi</button>
        <button onClick={() => setFestival('Pongal')} style={{ marginLeft: '10px' }}>Change to Pongal</button>
      </div>
    </div>
  );
};

export default FestivalApp;
