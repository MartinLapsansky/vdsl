import React, { useEffect, useState } from 'react';
import './TaskList.css';
import 'react-toastify/dist/ReactToastify.css';
import axios from "axios";

const TaskList = () => {
    const [tasks, setTasks] = useState([]);
    const [currentTaskIndex, setCurrentTaskIndex] = useState(0);
    const [answer, setAnswer] = useState('');
    const [showHint, setShowHint] = useState(false);

    useEffect(() => {
        axios.get('/api/escape-room/tasks')
            .then(response => {
                const tasks = response.data;
                if (tasks.length > 0) {
                    setTasks(tasks);
                    console.log('Initial Tasks:', tasks);
                }
            })
            .catch(error => console.error('Error fetching tasks:', error));
    }, []);

    const handleInputChange = (value) => {
        setAnswer(value);
    };

    const handleHintClick = () => {
        setShowHint(true);
    };

    const handleConfirmClick = () => {
        const currentTask = tasks[currentTaskIndex];
        console.log('Current Task:', currentTask);
        console.log('Provided Answer:', answer);

        if (currentTask && answer === currentTask.solution.answer) {
            alert('Correct! Proceeding to the next task...');
            setTimeout(() => {
                // Move to the next task only if the answer is correct
                if (currentTaskIndex + 1 < tasks.length) {
                    setCurrentTaskIndex(prevIndex => prevIndex + 1);
                } else {
                    alert('Congratulations, you have completed all tasks!');
                }
                setAnswer('');
                setShowHint(false);
            }, 500);
        } else {
            alert('Incorrect answer, please try again.');
            console.log('Incorrect answer provided.');
        }
    };

    if (tasks.length === 0) {
        return <div>Loading...</div>;
    }

    const currentTask = tasks[currentTaskIndex];

    return (
        <div className="task-list">
            <div key={currentTask.id} className="task">
                <h2>{currentTask.name}</h2>
                <p>{currentTask.description}</p>
                {showHint && <p><strong>Hint:</strong> {currentTask.hint}</p>}
                <p><strong>Details:</strong> {currentTask.taskDetails}</p>

                {/* Input for answering */}
                <input
                    type="text"
                    value={answer}
                    onChange={(e) => handleInputChange(e.target.value)}
                    placeholder="Enter your answer"
                />

                {/* Confirm button */}
                <button onClick={handleConfirmClick}>Confirm</button>

                {/* Hint button */}
                <button onClick={handleHintClick}>Hint</button>
            </div>
        </div>
    );
};

export default TaskList;
