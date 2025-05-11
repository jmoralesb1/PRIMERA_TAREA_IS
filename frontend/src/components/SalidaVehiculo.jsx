import React, { useState } from 'react';
import axios from 'axios';

const Salida = () => {
    const [placa, setPlaca] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // Enviar la placa al backend para registrar la salida
            await axios.post(`http://localhost:8080/api/registro/salida`, { placa });
            alert('Salida registrada correctamente');
            setPlaca(''); // Limpiar el campo
        } catch (err) {
            console.error('Error al registrar salida:', err);
            alert('Error al registrar salida del vehículo. Verifique la placa.');
        }
    };

    return (
        <div>
            <h2>Registrar Salida</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={placa}
                    onChange={(e) => setPlaca(e.target.value)}
                    placeholder="Ingrese la placa del vehículo"
                    required
                />
                <button type="submit">Registrar Salida</button>
            </form>
        </div>
    );
};

export default Salida;