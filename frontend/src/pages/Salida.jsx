import React, { useEffect, useState } from 'react';
import { obtenerRegistrosActivos, registrarSalida } from '../services/api';

const Salida = () => {
  const [vehiculos, setVehiculos] = useState([]);
  const [vehiculoSeleccionado, setVehiculoSeleccionado] = useState('');
  const [placaManual, setPlacaManual] = useState('');
  const [error, setError] = useState(null);
  const [mensaje, setMensaje] = useState(null);

  useEffect(() => {
    const cargarVehiculos = async () => {
      try {
        const response = await obtenerRegistrosActivos();
        setVehiculos(response.data);
        setError(null); // Limpiar errores previos
      } catch (error) {
        console.error('Error al cargar los vehículos activos:', error);
        setError('No se pudieron cargar los vehículos activos. Intenta nuevamente más tarde.');
      }
    };

    cargarVehiculos();
  }, []);

  const manejarSalida = async () => {
    if (!vehiculoSeleccionado && !placaManual.trim()) {
      alert('Por favor, selecciona un vehículo o ingresa una placa válida.');
      return;
    }

    try {
      const registro = vehiculoSeleccionado || placaManual.trim(); // Prioriza la selección, pero permite usar la placa manual
      await registrarSalida({ placa: registro });
      alert('Salida registrada correctamente.');
      setMensaje('Salida registrada correctamente.');
      setError(null);

      if (vehiculoSeleccionado) {
        // Si el vehículo fue seleccionado, elimínalo de la lista
        setVehiculos((prev) =>
          prev.filter((vehiculo) => vehiculo.id !== vehiculoSeleccionado)
        );
        setVehiculoSeleccionado('');
      }
      setPlacaManual(''); // Limpiar el campo de texto
    } catch (error) {
      console.error('Error al registrar la salida:', error);
      setError('Error al registrar la salida. Intenta nuevamente.');
      setMensaje(null);
    }
  };

  return (
    <div>
      <h2>Registrar Salida</h2>
      {error && <p className="text-red-500">{error}</p>}
      {mensaje && <p className="text-green-500">{mensaje}</p>}

      <div>
        <label htmlFor="placaManual">Ingresar Placa Manualmente:</label>
        <input
          id="placaManual"
          type="text"
          value={placaManual}
          onChange={(e) => setPlacaManual(e.target.value)}
          placeholder="Ingresa la placa del vehículo"
          className="border p-2 mb-4"
        />
      </div>

      <div>
        <label htmlFor="vehiculoSeleccionado">Seleccionar un Vehículo:</label>
        <select
          id="vehiculoSeleccionado"
          value={vehiculoSeleccionado}
          onChange={(e) => setVehiculoSeleccionado(e.target.value)}
        >
          <option value="">Seleccione un vehículo</option>
          {vehiculos.map((vehiculo) => (
            <option key={vehiculo.id} value={vehiculo.placa}>
              {vehiculo.placa} - {vehiculo.tipo} - {vehiculo.color}
            </option>
          ))}
        </select>
      </div>

      <button onClick={manejarSalida} className="p-2 bg-blue-500 text-white">
        Registrar Salida
      </button>
    </div>
  );
};

export default Salida;